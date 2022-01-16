package com.example.nettyserver.client;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientTest {

    public static void main(String[] args) {

        // 1 创建okhttp客户端对象
        OkHttpClient client  = new OkHttpClient();
        // 2 request 默认是get请求
        Request request = new  Request.Builder().url("http://localhost:8801/test").build();

        // 3 进行请求操作
        try {
            Response response = client.newCall(request).execute();
            // 4 判断是否请求成功
            if(response.isSuccessful()){
                // 得到响应体中的身体,将其转成  string
                String string = response.body().string();
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
