package com.example.nettyserver.client;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

public class HttpClient {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://localhost:8801/test");

        CloseableHttpResponse execute = httpclient.execute(httpGet);

        try{
            HttpEntity entity = execute.getEntity();
            String content = EntityUtils.toString(entity, "UTF-8");
            System.out.println("输出："+ content);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
