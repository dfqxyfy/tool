package com.sunlands;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class MyTest {


    public static void main(String[] args) throws Exception {

        HttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost("http://www.baidu.com");
        HttpResponse response = httpClient.execute(httpPost);

        HttpEntity entity = response.getEntity();
        if (entity != null) {
            long len = entity.getContentLength();
            if (len != -1 && len < 2048) {
                System.out.println(EntityUtils.toString(entity));
            } else {
            }
        }
    }
}
