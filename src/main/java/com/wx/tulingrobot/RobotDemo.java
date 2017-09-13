package com.wx.tulingrobot;

import com.wx.service.HTTPService;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hanqian18790 on 2017/9/13.
 * hello
 */
public class RobotDemo {
    public static void main(String[] args){
        HTTPService httpService = new HTTPService();
        String url = "http://www.tuling123.com/openapi/api";
        String method = "POST";
        String paramStr = "";
        Map<String,Object> params = new HashMap<>();
        params.put("key","5b9b266d81324fa8a6cd8f97dd57eb61");
        params.put("info","唱歌");
        params.put("loc","Tokoy");
        params.put("userid","root");
        //name1=value1&name2=value2
        for(String key:params.keySet()){
            paramStr = paramStr+key+"="+params.get(key)+"&";
        }
        String hello = httpService.sendPost(url,paramStr);
        System.out.println(hello);
    }
}
