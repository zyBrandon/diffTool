package com.example.demo.mapper;

import com.example.demo.model.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;

@Mapper
public interface GetCaseListMapper {
    @Select("select * from diff_case where submitter=#{submitter} and case_status='1'")
    ArrayList<Case> getCaseListMapper(@Param("submitter") String submitter);
}
