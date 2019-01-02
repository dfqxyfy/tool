package service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ProcessBank")
public class ProcessBank extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private String payUrl="";

    public ProcessBank() {
        super();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get param
        String soTien = request.getParameter("amount"); // >=10000vnd
        String orderId = request.getParameter("order_id");
        String orderInfo = request.getParameter("order_info");
        String accKey = ""; //product's access key (get value from TrueMoney Pay product detail)
        String command = "request_transaction";
        String returnUrl = "http://localhost:8080/TestBank/CommitRequest";
        try {
            sendPost(accKey, soTien, command, orderId, orderInfo, returnUrl);
            response.sendRedirect(payUrl);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private void sendPost(String access_key, String amount, String command,
            String order_id, String order_info, String return_url) throws Exception {
        String url = "https://api.pay.truemoney.com.vn/bank-charging/service/v2";
        String secretKey =""; //product's secret key (get value from TrueMoney Pay product detail)
        String signature = generateSignature(access_key, amount, command, order_id, order_info, return_url, secretKey);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "access_key="+access_key+"&amount="+amount+"&command="+command+"&order_id="+order_id
                +"&order_info="+order_info+"&return_url="+return_url+"&signature="+signature;
        
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
        System.out.println("URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response  = new StringBuffer();
        while ((inputLine = in.readLine())!=null) {
            response.append(inputLine);
        }
        in.close();
        String json = response.toString();
        System.out.println(json);
        JSONObject jObj = new JSONObject(json);
        payUrl = jObj.getString("pay_url");
        System.out.println("\nRedirect to URL:"+payUrl);
    }
    
    public String generateSignature(String access_key, String amount,
            String command, String order_id, String order_info,
            String return_url, String secret) {
        String urlParameters = "";
        String signature = "";
        if ((access_key != null) && (amount != null) && (command != null)
                && (order_id != null) && (order_info != null)
                && (return_url != null)) {
            urlParameters = "access_key="+access_key+"&amount="+amount+"&command="+command+"&order_id="+order_id
                    +"&order_info="+order_info+"&return_url="+return_url;
            signature = hmacDigest(urlParameters, secret, "HmacSHA256");
            System.out.println("Signature:"+signature);
        }
        return signature;
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

}