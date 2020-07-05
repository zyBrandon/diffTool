package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.library.WordKey;
import netscape.javascript.JSObject;
import org.apache.http.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import java.io.IOException;
import java.util.Map;

@Service
public class PostUrl extends Thread{




    @Async
    public String PostUrl(String url, String param, String method) throws Exception{
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        url = url + param;
        CloseableHttpResponse response = null;
        if (method.equals(WordKey.Get)){
            // 创建HttpGet请求
            HttpGet httpGet = new HttpGet(url);
            try {
                // 执行请求
                response = httpclient.execute(httpGet);
                // 判断返回状态是否为200
                if (response.getStatusLine().getStatusCode() == 200) {
                    // 解析响应，获取数据
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    return content;

                }

            } finally {
                if (response != null) {
                    // 关闭资源
                    response.close();
                }
                // 关闭对象
                httpclient.close();
            }
        } else if (method.equals(WordKey.Post)){
            HttpPost httpPost = new HttpPost(url);
            try {
                // 执行请求
                response = httpclient.execute(httpPost);
                // 判断返回状态是否为200
                if (response.getStatusLine().getStatusCode() == 200) {
                    // 解析响应，获取数据
                    String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                    return content;
                }

            } finally {
                if (response != null) {
                    // 关闭资源
                    response.close();
                }
                // 关闭对象
                httpclient.close();
            }
        }
        return null;

    }

    @Bean
    public RequestConfig requestConfig(){

        return RequestConfig.custom().setConnectionRequestTimeout(2000)  //从链接池获取连接的超时时间
                .setConnectTimeout(2000)    //与服务器连接超时时间，创建socket连接的超时时间
                .setSocketTimeout(2000)   //socket读取数据的超时时间，从服务器获取数据的超时时间
                .build();
    }


    @Bean
    public void setPoolTime(){
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        // Increase max total connection to 200
        cm.setMaxTotal(200);
        // Increase default max connection per route to 20
        cm.setDefaultMaxPerRoute(20);
        // Increase max connections for localhost:80 to 50
        HttpHost localhost = new HttpHost("locahost", 80);
        cm.setMaxPerRoute(new HttpRoute(localhost), 50);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .build();
    }


}
