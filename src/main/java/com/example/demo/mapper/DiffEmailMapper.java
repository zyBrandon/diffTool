package com.example.demo.mapper;

import com.example.demo.model.DiffCaseEmail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.Date;

@Mapper
public interface DiffEmailMapper {
    @Insert("insert into diff_case_email(case_id,diff_result,operate_user_id,is_send,create_time,update_time) values(#{case_id},#{diff_result},#{operate_user_id},#{is_send},#{create_time},#{update_time})")
    int addDiffEmail(@Param("case_id") int case_id, @Param("diff_result") String diff_result, @Param("operate_user_id") int operate_user_id,
                     @Param("is_send") int is_send, @Param("create_time") int create_time,@Param("update_time") int update_time);


    @Select("select case_id,operate_user_id,is_send from diff_case_email where case_id=#{case_id} and update_time>#{today_start_time} and update_time<#{today_end_time}")
    ArrayList<DiffCaseEmail> getDiffEmailByCaseId(@Param("case_id") int case_id,@Param("today_start_time") int today_start_time,@Param("today_end_time") int today_end_time);

}
