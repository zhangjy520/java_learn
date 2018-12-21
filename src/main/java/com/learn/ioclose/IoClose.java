package com.learn.ioclose;

import java.io.*;

public class IoClose {
    //有关联关系的流关闭，只需要关闭其中任何一个即可
    public static void main(String[] args) {
        Reader reader = null;
        InputStream in = null;
        InputStream in1 = null;
        try {
           in = new FileInputStream(new File("C:\\Users\\shenyy\\Desktop\\git.mp4"));
           in1 = new FileInputStream(new File("C:\\Users\\shenyy\\Desktop\\git.mp4"));
            reader = new InputStreamReader(in);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                reader.close();
                in.close();
                in1.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
