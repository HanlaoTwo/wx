package com.wx.controller;

import com.wx.scriptservice.JavascriptService;
import com.wx.scriptservice.PythonService;
import com.wx.scriptservice.testpy;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

/**
 * Created by hanqian18790 on 2017/6/9.
 * hi
 */

@Controller
public class TestMsgController {

    private Logger logger = Logger.getLogger(TestMsgController.class);
    private String jspath = TestMsgController.class.getResource("/").getPath() + "scripts/textchat.js";
    private String pypath=testpy.class.getResource("/").getPath() + "python/test.py";


    private ScriptEngine scriptEngine = JavascriptService.getInstance(jspath).engine;


    @RequestMapping(value="/msg")
    public String showView() {
        return "test";
    }

    @RequestMapping(value="/js")
    public String chat() {
        String words = "hahhaha";
        try {
            words = scriptEngine.eval("chat('--->hello')").toString();
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return words;
    }

    @RequestMapping(value = "/py")
    public String body(){
        //return testpy.hello();
        return new PythonService().runScript("test.py");
    }
}
