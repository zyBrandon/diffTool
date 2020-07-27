package com.example.demo.library;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class JsonDiff {



    public boolean isEqual(String jsonOnline,String jsonMirror){
        return jsonMirror == null || jsonOnline == null ? false : jsonOnline.equals(jsonMirror);
    }

    public String getRes(String jsonOnline,String jsonMirror){
        JSONArray jsonMirrorArr = JSON.parseArray(jsonMirror);
        JSONArray jsonOnlineArr = JSON.parseArray(jsonOnline);

        String res = "";

        //比较的是Mirror比Online的size
        res =  jsonMirrorArr.size() < jsonOnlineArr.size() ?  WordKey.sizeDiff :  "";
        //比较key
        for (int i = 0; i < jsonMirrorArr.size();i++){
            if (jsonMirrorArr.get(i) != jsonOnlineArr.get(i)){
                //res = WordKey.
            }
        }
        //比较value

        //相等

        return res == null ? WordKey.equalDiff : res;
    }

}
