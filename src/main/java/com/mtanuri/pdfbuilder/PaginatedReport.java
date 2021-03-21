package com.mtanuri.pdfbuilder;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;


public abstract class PaginatedReport extends Report {

    @Override
    public void addContent() throws Exception {
        setHeader();
        newLineSpacing();
        setBody();
        newLineSpacing();
        setFooter();
    }

    protected abstract void setHeader() throws IOException, DocumentException;

    protected abstract void setBody() throws IOException, DocumentException, NoSuchMethodException;

    protected abstract void setFooter() throws IOException, DocumentException;

    protected void newLineSpacing() throws DocumentException {
        Paragraph paragraph = new Paragraph();
        paragraph.setSpacingBefore(getLineSpacing());
        paragraph.add(Chunk.NEWLINE);
        document.add(paragraph);
    }

    protected int getLineSpacing() {
        return 0;
    }

    protected void printDateTime(String dateFormatPattern, String timeZoneId, String label) throws DocumentException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTimeZone(TimeZone.getTimeZone(timeZoneId));
        String now = sdf.format(gregorianCalendar.getTime());
        document.add(new Paragraph(label + now));
    }
}
