package com.example.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.library.ReplaceHost;
import com.example.demo.library.Url_Collection;
import com.example.demo.library.WordKey;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.execchain.RetryExec;

import java.net.URLEncoder;

@Service
public class PostUrl extends Thread{


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String test(){
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            response = httpclient.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                //logger.warn("返回状态值为200");
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;

            }
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    //@Async
    public String PostUrl(String url, String param, String method,String operate) throws Exception{

        //替换地址，端口号保留
        if (operate.equals(WordKey.OnlineRep)){
            url = ReplaceHost.replaceHost(url, Url_Collection.online_url);
        } else if (operate.equals(WordKey.MirrorRes)){
            url = ReplaceHost.replaceHost(url,Url_Collection.mirror_url);
        }


        //请求
        if (method.equals(WordKey.Get)){
            return Method_Get(url, param);
        } else if (method.equals(WordKey.Post)){
            return Method_Post(url, param);
        }
        return null;

    }

    public String Method_Get(String url,String param) throws Exception{
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        url = url + "?" + toUTF8(param);
        //进行转码

        logger.warn(url);
        CloseableHttpResponse response = null;
        // 创建HttpGet请求
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            // 执行请求
            response = httpclient.execute(httpGet);
            //logger.warn("获取response成功");
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                //logger.warn("返回状态值为200");
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
        return null;
    }

    public String Method_Post(String url,String param) throws Exception{
        // 创建Httpclient对象
        CloseableHttpClient httpclient = HttpClients.createDefault();
        url = url + "?" + toUTF8(param);
        url = toUTF8(url);
        CloseableHttpResponse response = null;
        // 创建HttpGet请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.addHeader("Content-Type", "application/json;charset=UTF-8");
        try {
            // 执行请求
            response = httpclient.execute(httpPost);
            logger.warn("获取response成功");
            // 判断返回状态是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                // 解析响应，获取数据
                logger.warn("返回状态值为200");
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
        return null;
    }

    public String toUTF8(String url) {
        try {
            url = URLEncoder.encode(url,"utf-8");
            url = url.replaceAll("%3D","=");
            logger.warn(url);
            url = url.replaceAll("%26","&");
            return url;
        } catch (Exception e){
            logger.warn(e.getMessage());
        }
        return "";

    }

}
