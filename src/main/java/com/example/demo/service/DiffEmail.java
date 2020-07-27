package com.example.demo.service;

import com.example.demo.mapper.DiffEmailMapper;
import com.example.demo.model.DiffCaseEmail;
import com.example.demo.util.ApiResult;
import com.example.demo.util.RedisUtil;
import com.example.demo.util.TimeUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class DiffEmail {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private DiffEmailMapper diffEmailMapper;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    public ApiResult addDiffEmailToDB(int case_id,String diff_result,int operate_user_id,int is_send){

        //判断是否存在diff结果，一天限制三条数据
        long time = TimeUtil.getTime();

        int start_time = (int) (time - TimeUtil.Day);
        int end_time = (int) time;

        ArrayList<DiffCaseEmail> diffEmails = diffEmailMapper.getDiffEmailByCaseId(case_id,start_time,end_time);
        if (diff_result == null){
            int diffcaseCount = 0;
            for (DiffCaseEmail diffCaseEmail:diffEmails){
                diffcaseCount++;
            }
            if (diffcaseCount < 3){
                int i = diffEmailMapper.addDiffEmail(case_id,diff_result,operate_user_id,is_send,(int)time,(int)time);
                if (i == 0){
                    logger.warn(String.valueOf(getClass()) + "addDiffEmailToDB"+"插入数据异常");
                    return ApiResult.success(201,"","");
                }
            }

        }

        return ApiResult.success(200,"","");
    }

    public ApiResult addDiffResToRedis(int case_id,String diff_result,int oprate_user_id){
        if (diff_result == null){
            diff_result = "ok";
        }

        int time = (int)TimeUtil.getTime();

        String key = case_id + ":" + oprate_user_id + ":" + time;
        String value = diff_result;

        boolean setRes = redisUtil.set(key,value,TimeUtil.Week);
        if (setRes == false){
            logger.warn(String.valueOf(getClass()) + "addDiffResToRedis" + "插入redis失败");
            return ApiResult.success(201,"","");
        }

        return ApiResult.success(200,"","");
    }


}
