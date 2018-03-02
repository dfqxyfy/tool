package com.sunlands;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
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

public class HttpClientSmTest {

    public void post() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost("https://e.sm.cn/api/campaign/getAllCampaign");
        httppost.setHeader(new BasicHeader("Content-Type","application/json; charset=utf-8"));

        try {
            //StringEntity stringEntity = new StringEntity("{\"header\":{\"username\":\"北京尚佳崇业教育有限公司\",\"password\":\"Sunland2017\",\"token\":\"b60fe899-1927-440c-b056-7050e35c415a\",\"target\":\"尚德机构01\"},\"body\":{\"requestData\":[\"account_all\"]}}}", Charset.forName("utf-8"));
            //StringEntity stringEntity = new StringEntity("{\"header\":{\"username\":\"北京尚佳崇业教育有限公司\",\"password\":\"Sunland2017\",\"token\":\"b60fe899-1927-440c-b056-7050e35c415a\"},\"body\":{\"requestData\":[\"account_all\"]}}}", Charset.forName("utf-8"));
            StringEntity stringEntity = new StringEntity("{\"header\":{\"username\":\"北京尚佳崇业教育有限公司\",\"password\":\"Sunland2017\",\"token\":\"b60fe899-1927-440c-b056-7050e35c415a\",\"target\":\"尚德机构01\"},\"body\":{}}}", Charset.forName("utf-8"));
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