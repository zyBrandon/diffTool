package com.example.demo.service;

import com.example.demo.mapper.GetCaseListMapper;
import com.example.demo.model.Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GetCaseList {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GetCaseListMapper GetCaseListMapper;

    public ArrayList<Case> getCaseList(String submitter){
        if (submitter == null){
            return null;
        }

        //todo 获取权限
        ArrayList<Case> arrCaseyList = GetCaseListMapper.getCaseListMapper(submitter);
        if (arrCaseyList == null){
            return null;
        }
        return arrCaseyList;
    }
}
