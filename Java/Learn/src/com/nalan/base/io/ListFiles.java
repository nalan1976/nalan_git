package com.nalan.base.io;

import java.io.File;
import java.net.URL;

public class ListFiles {
    public static void main(String[] args) throws Exception{
//        URL CurClassUrl = this.getClass().getResource("e:\\Develop\\Java\\书籍\\");
        //不支持中文路径
//        String s = java.net.URLDecoder.decode(CurClassUrl.getPath(),"utf-8");
        String s = java.net.URLDecoder.decode("e:\\Develop\\Java\\书籍\\","utf-8");
        File f = new File(s);

        for(File temp : f.listFiles()) {
            if(temp.isFile()) {
                System.out.println(temp.getName());
            }
        }
    }
}
