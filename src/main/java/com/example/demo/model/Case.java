package com.example.demo.model;

import com.alibaba.fastjson.JSON;

import java.util.Date;

public class Case {
    private int id;
    //地址
    private String url;
    //参数
    private String param;
    //请求方式
    private String method;
    //case等级
    private String grade;
    //提交人
    private String submitter;
    //case状态
    private String case_status;
    //创建时间
    private Date create_time;
    //更新时间
    private Date update_time;
    //额外说明
    private String ext;

    public Case(){

    }

    public Case(int id,String url,String param,String method,String grade,String submitter,String case_status,
                Date create_time,Date update_time,String ext){
        this.id = id;
        this.url = url;
        this.param = param;
        this.method = method;
        this.grade = grade;
        this.submitter = submitter;
        this.case_status = case_status;
        this.create_time = create_time;
        this.update_time = update_time;
        this.ext = ext;
    }

    public int getId() {
        return id;
    }

    public String isCase_status() {
        return case_status;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public String getExt() {
        return ext;
    }

    public String getGrade() {
        return grade;
    }

    public String getMethod() {
        return method;
    }

    public String getParam() {
        return param;
    }

    public String getSubmitter() {
        return submitter;
    }

    public String getUrl() {
        return url;
    }




    public void setCase_status(String case_status) {
        this.case_status = case_status;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }
}
