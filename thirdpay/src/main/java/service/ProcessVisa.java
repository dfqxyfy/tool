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
import java.util.Random;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ProcessVisa")
public class ProcessVisa extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ProcessVisa() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String access_key = "";
        String secret_Key = ""; 
        String amount = request.getParameter("amount");
        String order_id = randomString();
        String order_info = "Demo Visa";
        String return_url = "http://localhost:8080/Test";
        
        try {
            String json = sendPost(access_key, amount, order_id, order_info, return_url, secret_Key);
            JSONObject jObj = new JSONObject(json);
            String payUrl = jObj.getString("pay_url");
            System.out.println("\nRedirect to URL:" + payUrl);
            response.sendRedirect(payUrl);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }       
    }
    
    //order id(created by merchant system)
        private String randomString() {
            final String RAND = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            Random random = new Random();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < 7; i++) {
                builder.append(RAND.charAt(random.nextInt(RAND.length())));
            }
            return builder.toString();
        }

    private String sendPost(String access_key, String amount, String order_id, String order_info, String return_url, String secretKey)
            throws Exception {
        String url = "https://api.pay.truemoney.com.vn/visa-charging/api/handle/request";
        
        String signature = generateSignature(access_key, amount, order_id, order_info, secretKey);
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String urlParameters = "access_key=" + access_key + "&amount=" + amount + "&order_id=" + order_id
                + "&order_info=" + order_info + "&return_url=" + return_url + "&signature=" + signature;

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
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String json = response.toString();
        System.out.println(json);
        return json;
    }

    private String generateSignature(String access_key, String amount, String order_id, String order_info,
            String secret) {
        String urlParameters = "";
        String signature = "";
        if ((access_key != null) && (amount != null) && (order_id != null) && (order_info != null)) {
            urlParameters = "access_key=" + access_key + "&amount=" + amount + "&order_id=" + order_id + "&order_info="
                    + order_info;
            signature = hmacDigest(urlParameters, secret, "HmacSHA256");
            System.out.println("Signature:" + signature);
        }
        return signature;
    }

    private static String hmacDigest(String msg, String keyString, String algo) {
        String digest = "";
        try {
            if (keyString != null && keyString.length() > 0) {
                SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"), algo);
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