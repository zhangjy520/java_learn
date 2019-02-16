package com.learn.pdftoword;
import com.sun.jna.Library;
import com.sun.jna.Native;
public class Pdf2WordBaseSolidFramwork {

    public interface Dll extends Library{
        Dll instance = (Dll)Native.loadLibrary("D:\\zjywork\\java_learn\\src\\main\\resources\\SolidFramework.dll", Dll.class);
        public int Convert(String sourceFileName,String destinationFileName);
    }

    public static void main(String[] args) {
        System.out.println();
        int sum = Dll.instance.Convert("C:\\Users\\shenyy\\Desktop\\1-s2.0-S0378216617306999-main.pdf", "C:\\Users\\shenyy\\Desktop\\dd.doc");
    }

}