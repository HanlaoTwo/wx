package com.wx.scriptservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by hanqian18790 on 2017/6/19.
 */
public class PythonService {
    private static String path = testpy.class.getResource("/").getPath() + "python/";
    public static String runScript(String file){
        String rs = "";
        try {
            Process pr = Runtime.getRuntime().exec("python " + path+file);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                rs = rs+line;
            }
            in.close();
            pr.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
