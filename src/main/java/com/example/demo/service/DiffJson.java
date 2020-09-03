package com.example.demo.service;


import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.library.*;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DiffJson extends BaseAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiResult diffjson(String json_mirror, String json_online){

        System.out.println();
        logger.warn(String.valueOf(JSON.parse(json_mirror)));
        //转码为utf-8
        String res = String.valueOf(JSON.parse(json_mirror));


        //json_online = "[{\"code\":200][\"msg\":\"Success\"][\"data\":{\"zy\":100}}]]";
        //json_mirror = "[{\"code\":200,\"msg\":\"Success\",\"data\":{}}]";

        //String json1 = "{\"data\":{\"respCode\":[1,2,3],\"errMsg\":\"\",\"respData\":{\"nav\":[{\"aa\":[1,2,3]},{},{\"text\":\"大灰机\",\"href\":\"//mbiubiubiu\"}]}}}";
        //String json2 = "{\"data\":{\"aaaa\":1,\"respData\":{\"nav\":[{\"aa\":[2,1,3,4]},{},{\"text\":\"大灰机2\",\"href\":\"//mbiubiubiu\"}]},\"errMsg\":\"\",}}";

        /*if (res == null){
            return ApiResult.success(WordKey.DiffFasle,"","");
        }


        RecursiveDiff diffUtil = new RecursiveDiff(json_mirror, json_online);

        diffUtil.compareJson();

        System.out.println(diffUtil.getDiffRet());
        if (diffUtil.getDiffRet() == null){
            return ApiResult.success(WordKey.DiffFasle,"","");
        }

        return ApiResult.success(WordKey.DiffTrue,"",diffUtil.getDiffRet());
        */
        return ApiResult.success(WordKey.DiffTrue,"",JsonDiff.getRes(json_online,json_mirror));
    }





}