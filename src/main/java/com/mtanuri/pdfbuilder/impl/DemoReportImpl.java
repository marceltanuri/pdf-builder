package com.mtanuri.pdfbuilder.impl;

import com.mtanuri.pdfbuilder.Report;
import com.itextpdf.text.*;

public class DemoReportImpl extends Report {

    @Override
    public void addContent() throws DocumentException {
        Font font = FontFactory.getFont(REGULAR, 12);
        Font bold = FontFactory.getFont(BOLD, 12);
        document.add(new Paragraph("The Strange Case of Dr. Jekyll and Mr. Hyde", new
                Font(Font.FontFamily.HELVETICA, 18, Font.BOLD, new BaseColor(0, 0, 255))));
        document.add(new Paragraph("Robert Louis Stevenson", new
                Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, new BaseColor(0, 0, 255))));
    }
}
