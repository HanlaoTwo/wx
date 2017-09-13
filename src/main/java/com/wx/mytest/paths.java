package com.wx.mytest;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by hanqian18790 on 2017/6/12.
 * hi
 */
public class paths {

    public static void main(String args[]) throws
            FileNotFoundException {

        System.out.println(paths.class.
                getResource("/").
                getPath());

        System.out.println(paths.class
                .getResource("")
                .getPath());

        System.out.println(paths.class
                .getClassLoader()
                .getResource("")
                .getPath());

        FileReader file =
                new FileReader(paths.class
                        .getResource("/")
                        .getPath() + "scripts/textchat.js");
    }
}
