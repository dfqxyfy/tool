package cn.ccs.demo;

import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
@WebServlet(value = "/CommitRequest",urlPatterns = "CommitRequest")
public class CommitRequest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String json ="";

    public CommitRequest() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get param
        String accKey = request.getParameter("access_key");
        accKey = "63x7p8thhht1zf3bk7x9";
        String command = "close_transaction";
        String trans_ref = request.getParameter("trans_ref");
        String responseCode = request.getParameter("response_code");
        if (responseCode.equals("00")) {
          try {
              sendPost(accKey, command, trans_ref);

              JSONObject jObj = new JSONObject(json);
              String response_code = jObj.getString("response_code");

              if (response_code.equals("00")) {
                  // Merchants already processed data and saved transaction log here.
              } else {
                  // The information does not match, it will be saved in log and followed.
              }
          } catch (Exception e) {
              e.printStackTrace();
          }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    
    public static String hmacDigest(String msg, String keyString, String algo) {
        String digest = "";
        try {
            if (keyString != null && keyString.length() > 0) {
                SecretKeySpec key = new SecretKeySpec(
                        (keyString).getBytes("UTF-8"), algo);
                Mac mac = Mac.getInstance(algo);
                mac.init(key);
                byte[] bytes = mac.doFinal(msg.getBytes("ASCII"));
                StringBuffer hash = new StringBuffer();
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xFF & bytes[i]);
                    if (hex.length() == 1) {
                        hash.append('0');
                    }
                    hash.append(hex);
                }
                digest = hash.toString();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return digest;
    }
    
    public String generateSignature(String access_key, String command,
            String trans_ref, String secret) {
        String urlParameters = "";
        String signature = "";
        if ((access_key != null) && (command != null) && (trans_ref != null)) {
            urlParameters = "access_key="+access_key+"&command="+command+"&trans_ref="+trans_ref;
            signature = hmacDigest(urlParameters, secret, "HmacSHA256");
            System.out.println("Signature:" + signature);
        }
        return signature;
    }
    
    private void sendPost(String access_key, String command, String trans_ref)
            throws Exception {
        String url = "https://api.pay.truemoney.com.vn/bank-charging/service/v2";
        String secretKey = ""; // product's secret key (get value from TrueMoney Pay product detail)
        String signature = generateSignature(access_key, command, trans_ref,
                secretKey);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "access_key="+access_key+"&command="+command+"&trans_ref="+trans_ref+"&signature="+signature;

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        json = response.toString();
        System.out.println(json);
    }

}