package com.sunlands;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org. apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class HttpClientTestClone {

    /**
     * 发送 post请求访问本地应用并根据传递参数不同返回不同结果 
     */  
    public void post() {
        // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
        HttpPost httppost = new HttpPost("https://api.baidu.com/json/sms/service/AccountService/getAccountInfo");
        // 创建参数队列
        List<NameValuePair> formparams = new ArrayList<NameValuePair>();
        httppost.setHeader(new BasicHeader("Content-Type","application/json; charset=utf-8"));

        try {
            StringEntity stringEntity = new StringEntity("{\"header\":{\"username\":\"尚德128\",\"password\":\"2qy2uTZ2.1100\",\"token\":\"e345dc371fe49707fe498141f12e0b1b\",\"target\":\"尚德128\"},\"body\":{\"accountFields\":[\"userId\",\"balance\",\"cost\"]}}", Charset.forName("utf-8"));

            httppost.setEntity(stringEntity);
            System.out.println(stringEntity.toString());
            System.out.println("executing request " + httppost.getURI());
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }

    @Test
    public void myTest(){
        post();
    }
}
