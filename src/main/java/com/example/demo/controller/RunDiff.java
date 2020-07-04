package com.example.demo.controller;

import com.example.demo.library.WordKey;
import com.example.demo.model.Case;
import com.example.demo.service.GetCaseList;
import com.example.demo.util.ApiResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class RunDiff {
    @Autowired
    private GetCaseList GetCaseList;



    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "rundiff",method = RequestMethod.GET)
    public ApiResult rundiff(@RequestParam String submitter){
        HashMap res = new HashMap();
        //todo 判断是否登陆
        //todo 拉集合case
        ArrayList<Case> arrCaseList = GetCaseList.getCaseList(submitter);
        //todo 拉线上线下地址
        //todo 发请求
        //todo 生成报告

        return ApiResult.success(WordKey.Success,WordKey.SuccessMsg,res);
    }
}
