package com.example.demo.model;

import java.util.Date;

public class DiffCaseEmail {
    private int id;
    //跑diff case失败的id
    private int case_id;
    //diff 结果
    private String diff_result;
    //操作人id
    private int operate_user_id;
    //1.未发送邮件 2.发送邮件 3.发送邮件失败
    private int is_send;
    //创建时间
    private Date create_time;
    //更新时间
    private Date update_time;

    public DiffCaseEmail(){

    }

    public DiffCaseEmail(int id,int case_id,String diff_result,int operate_user_id,int is_send,
                         Date create_time,Date update_time){
        this.id = id;
        this.case_id = case_id;
        this.diff_result = diff_result;
        this.operate_user_id = operate_user_id;
        this.is_send = is_send;
        this.create_time = create_time;
        this.update_time = update_time;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public int getCase_id() {
        return case_id;
    }

    public int getId() {
        return id;
    }

    public int getIs_send() {
        return is_send;
    }

    public int getOperate_user_id() {
        return operate_user_id;
    }

    public String getDiff_result() {
        return diff_result;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public void setDiff_result(String diff_result) {
        this.diff_result = diff_result;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIs_send(int is_send) {
        this.is_send = is_send;
    }

    public void setOperate_user_id(int operate_user_id) {
        this.operate_user_id = operate_user_id;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }
}
