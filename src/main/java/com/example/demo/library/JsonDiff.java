package com.example.demo.library;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class JsonDiff {

    public static boolean isEqual(String jsonOnline,String jsonMirror){
        return jsonMirror == null || jsonOnline == null ? false : jsonOnline.equals(jsonMirror);
    }

    public static String getRes(String jsonOnline,String jsonMirror){

        System.out.println(jsonOnline);
        JSONArray jsonMirrorArr = JSON.parseArray(jsonMirror);
        JSONArray jsonOnlineArr = JSON.parseArray(jsonOnline);
        //JSON jsonMirrorobj = JSON.parse(jsonMirror);


        String res = "";

        //比较的是Mirror比Online的size
        if (jsonMirrorArr.size() < jsonOnlineArr.size()){
            return WordKey.sizeDiff;
        }

        System.out.println(jsonMirrorArr.get(0));
        //比较key
        for (int i = 0; i < jsonMirrorArr.size();i++){
            for (int j = 0; j < jsonOnlineArr.size();j++){
                if (jsonMirrorArr.get(i) != jsonOnlineArr.get(j) && j == jsonOnlineArr.size()-1){
                    return WordKey.keyDiff;
                }

            }
        }
        //比较value

        //相等

        return res == null ? WordKey.equalDiff : res;
    }

}
