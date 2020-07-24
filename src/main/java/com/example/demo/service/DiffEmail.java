package com.example.demo.service;

import com.example.demo.mapper.DiffEmailMapper;
import com.example.demo.util.ApiResult;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class DiffEmail {

    @Autowired
    private DiffEmailMapper diffEmailMapper;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiResult addDiffEmailToDB(){

        return ApiResult.success(200,"","");
    }


}
