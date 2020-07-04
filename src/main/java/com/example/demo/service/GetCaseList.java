package com.example.demo.service;

import com.example.demo.model.Case;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GetCaseList {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public ArrayList<Case> getCaseList(String submitter){
        if (submitter == null){
            return null;
        }

        //todo 获取权限
        ArrayList<Case> arraCaseyList =
    }
}
