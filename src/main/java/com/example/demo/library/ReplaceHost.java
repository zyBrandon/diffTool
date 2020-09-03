package com.example.demo.library;

public class ReplaceHost {
    public static String replaceHost(String url,String replace_url){
        if (null == url || null == replace_url){
            return "";
        }

        String urlRes = "";
        int endNum = 0;
        for (int i = 0;i < url.length();i++){


            if (url.charAt(i) == ':'){
                endNum = i;
                break;
            }
        }

        if (endNum == 0 ){
            return "";
        }

        //http://10.210.40.99:8095/crmbusiness
        //
        for (int i = 0;i < url.length();i++){
            if (i > endNum){
                urlRes += url.charAt(i);
            } else {
                urlRes += replace_url.charAt(i);
            }



        }

        return urlRes;

    }


}
