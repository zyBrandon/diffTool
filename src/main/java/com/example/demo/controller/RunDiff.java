package com.example.demo.controller;

import com.example.demo.library.Url_Collection;
import com.example.demo.library.WordKey;
import com.example.demo.model.Case;
import com.example.demo.service.DiffEmail;
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

@RestController()
public class RunDiff {
    @Autowired
    private GetCaseList GetCaseList;

    @Autowired
    private PostUrl PostUrl;

    @Autowired
    private DiffJson diffJson;

    @Autowired
    private DiffEmail diffEmail;




    private Logger logger = LoggerFactory.getLogger(this.getClass());



    @RequestMapping(value = "rundiff",method = RequestMethod.GET)
    public ApiResult rundiff(@RequestParam String submitter){
        HashMap res = new HashMap();
        //todo 判断是否登陆 结果为user_id

        //todo 拉集合case
        ArrayList<Case> arrCaseList = GetCaseList.getCaseList(submitter);
        //todo 拉线上线下地址
        String online_url = Url_Collection.online_url == null ? Url_Collection.local_url : Url_Collection.online_url;
        String mirror_url = Url_Collection.mirror_url == null ? Url_Collection.local_url : Url_Collection.mirror_url;

        //todo 发请求
        for (Case evrcase: arrCaseList) {

            try {
                //post两个地方的接口
                String post_mirror = PostUrl.PostUrl(evrcase.getUrl(),evrcase.getParam(),evrcase.getMethod(),WordKey.OnlineRep);
                String post_online = PostUrl.PostUrl(evrcase.getUrl(),evrcase.getParam(),evrcase.getMethod(),WordKey.MirrorRes);
                if (post_online == null || post_mirror == null){
                    return ApiResult.success(WordKey.getPostResError,WordKey.getPostResErrorMsg,"");
                }

                // diff
                String diffRes = (String) diffJson.diffjson(post_mirror,post_online).getData();
                int case_id = evrcase.getId();
                //diff返回为空
                if (null == diffRes){
                    //todo 结果放入redie
                    int diffEmailRedisRes = diffEmail.addDiffResToRedis(case_id,"",0).getCode();
                    continue;
                }


                //否则报警处理 记录到db中，db每天定时任务去发邮件
                int diffEmailDbRes = diffEmail.addDiffEmailToDB(case_id,diffRes.toString(),0,0).getCode();


            } catch (Exception e){
                e.printStackTrace();
            }
        }





        //todo 生成报告

        return ApiResult.success(WordKey.Success,WordKey.SuccessMsg,res);
    }
}
