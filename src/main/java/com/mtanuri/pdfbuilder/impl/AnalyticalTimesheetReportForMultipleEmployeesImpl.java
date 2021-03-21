package com.mtanuri.pdfbuilder.impl;

import com.mtanuri.pdfbuilder.PaginatedReport;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import java.io.IOException;

public class AnalyticalTimesheetReportForMultipleEmployeesImpl extends PaginatedReport {
    @Override
    protected void setHeader() throws IOException, DocumentException {
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("EXTRATO DE BANCO DE HORAS - ANALÍTICO"));
        table.addCell(cell);

        document.add(table);
    }

    @Override
    protected void setBody() throws IOException, DocumentException {

    }

    @Override
    protected void setFooter() throws IOException, DocumentException {
        super.printDateTime("dd/MM/yyyy", "America/Sao_Paulo", "Consulta realizada em: ");
    }
}
