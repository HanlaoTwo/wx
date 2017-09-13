package com.wx.scriptservice;

import org.apache.log4j.Logger;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by hanqian18790 on 2017/6/12.
 * hi
 */
public class testJS {

    private static Logger logger = Logger.getLogger(testJS.class);
    public static void main(String args[]) {

        String path = "";
        path = testJS.
                class.getResource("/").
                getPath() + "scripts/textchat.js";
        ScriptEngine javascriptEngine = JavascriptService.
                getInstance(path).engine;

        System.out.println(path);
        logger.error("\n\n\n\n----------------"+path+"\n\n\n");


        try {
            String hi = javascriptEngine.eval("chat(' pigy')").toString();
            System.out.println(hi + "\n");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

}

