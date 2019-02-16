package com.learn.pdftoword;


import com.bcl.easypdf.EasyPDF;
import com.bcl.easypdf.EasyPDFPrinter.IPrintJob;
import com.bcl.easypdf.EasyPDFPrinter.IPrinter;


public class Pdf2word {
    public static void main(String[] args) {
        try {
            EasyPDF.initialize();
            IPrinter printer = new IPrinter();
            IPrintJob pj = printer.getPrintJob();
            pj.PrintOut("C:\\Users\\shenyy\\Desktop\\1-s2.0-S0378216617306999-main.pdf", "C:\\Users\\shenyy\\Desktop\\dd.doc");
            EasyPDF.uninitialize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
