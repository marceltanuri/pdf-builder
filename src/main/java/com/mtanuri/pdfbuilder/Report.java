package com.mtanuri.pdfbuilder;


import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;


public abstract class Report {

    protected Document document;
    protected static final String REGULAR = "/fonts/Calibri Regular.ttf";
    protected static final String BOLD = "/fonts/Calibri Bold.TTF";
    protected static final String ITALIC = "/fonts/Calibri Italic.ttf";

    public OutputStream print(Map<String, String> params) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();

        addContent();

        document.close();
        return outputStream;
    }


    public abstract void addContent() throws Exception;
}
