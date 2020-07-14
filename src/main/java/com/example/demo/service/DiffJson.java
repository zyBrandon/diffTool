package com.example.demo.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.library.BaseAction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class DiffJson extends BaseAction {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String diffjson(String json_mirror,String json_online){

        logger.warn(String.valueOf(JSON.parse(json_mirror)));
        //logger.warn(json_mirror);
        //转码为utf-8
        String res = String.valueOf(JSON.parse(json_mirror));
        JSONObject json = (JSONObject) JSONObject.toJSON(res);
        return "";
    }
}
