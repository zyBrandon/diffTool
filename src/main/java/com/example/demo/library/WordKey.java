package com.example.demo.library;

public class WordKey {
    public static final int Success = 200;
    public static final String SuccessMsg = "Success";
    public static final int ParamError = 7000;
    public static final String ParamErrorMsg = "ParamError";
    public static final int DataError = 7001;
    public static final String DataErrorMsg = "DataError";
    public static final String Get = "get";
    public static final String Post = "post";
    public static final int getPostResError = 8001;
    public static final String getPostResErrorMsg = "getPostResErrorMsg";

    //diff对比不一致
    public static final int DiffFasle = 400001;
    public static final int DiffTrue = 400000;

    //线上字段
    public static final String OnlineRep = "OnlineRep";
    public static final String MirrorRes = "MirrorRes";

    //diff的失败关键字
    //online.size > mirror.size
    public static final String sizeDiff = "sizeDiff";
    //online.key diff mirror.key
    public static final String keyDiff = "keyDiff";
    //online.value diff mirror.value
    public static final String valueDiff = "valueDiff";
    //online equal mirror
    public static final String equalDiff = "equalDiff";

}
