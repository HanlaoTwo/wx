package com.wx.scriptservice;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by hanqian18790 on 2017/6/12.
 * hello
 */
public class JavascriptService {

    public ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
    private static JavascriptService service = null;
    private static String scriptpath = null;

    private JavascriptService() {
        try {
            engine.eval(new FileReader(scriptpath));
        } catch (ScriptException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static synchronized JavascriptService getInstance(String path) {

        if (service == null || !path.equals(scriptpath)) {
            scriptpath = path;
            service = new JavascriptService();
        }
        return service;
    }

    public static synchronized JavascriptService getNewInstance(String path) {

        scriptpath = path;
        service = new JavascriptService();
        return service;
    }


}
