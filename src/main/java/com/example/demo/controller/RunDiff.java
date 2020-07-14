package com.example.demo.controller;

import com.example.demo.library.WordKey;
import com.example.demo.model.Case;
import com.example.demo.service.DiffJson;
import com.example.demo.service.GetCaseList;
import com.example.demo.service.PostUrl;
import com.example.demo.util.ApiResult;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController(value = "rundiff")
public class RunDiff {
    @Autowired
    private GetCaseList GetCaseList;

    @Autowired
    private PostUrl PostUrl;

    @Autowired
    private DiffJson diffJson;




    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @RequestMapping(value = "rundiff",method = RequestMethod.GET)
    public ApiResult rundiff(@RequestParam String submitter){
        HashMap res = new HashMap();
        //todo 判断是否登陆

        //todo 拉集合case
        ArrayList<Case> arrCaseList = GetCaseList.getCaseList(submitter);
        //todo 拉线上线下地址
        //todo 发请求
        for (Case evrcase: arrCaseList) {
            //logger.warn(evrcase.getUrl());
            try {
                //String thread_post_one = PostUrl.PostUrl(evrcase.getUrl(),evrcase.getParam(),evrcase.getMethod());
                String thread_post_two = PostUrl.PostUrl(evrcase.getUrl(),evrcase.getParam(),evrcase.getMethod());
                logger.info(diffJson.diffjson(thread_post_two,""));
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //todo 生成报告

        return ApiResult.success(WordKey.Success,WordKey.SuccessMsg,res);
    }
}
