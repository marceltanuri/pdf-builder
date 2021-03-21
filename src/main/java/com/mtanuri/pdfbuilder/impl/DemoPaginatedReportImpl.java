package com.mtanuri.pdfbuilder.impl;

import com.mtanuri.pdfbuilder.PaginatedReport;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

public class DemoPaginatedReportImpl extends PaginatedReport {

    @Override
    protected void setHeader() throws DocumentException {

        PdfPTable table = new PdfPTable(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Header"));
        table.addCell(cell);

        document.add(table);
    }

    @Override
    protected void setBody() throws DocumentException {
        // a table with three columns
        PdfPTable table = new PdfPTable(3);
        // the cell object
        PdfPCell cell;
        // we add a cell with colspan 3
        cell = new PdfPCell(new Phrase("Cell with colspan 3"));
        cell.setColspan(3);
        table.addCell(cell);
        // now we add a cell with rowspan 2
        cell = new PdfPCell(new Phrase("Cell with rowspan 2"));
        cell.setRowspan(2);
        table.addCell(cell);
        // we add the four remaining cells with addCell()
        table.addCell("row 1; cell 1");
        table.addCell("row 1; cell 2");
        table.addCell("row 2; cell 1");
        table.addCell("row 2; cell 2");

        for (int i = 0; i < 100; i++) {
            cell = new PdfPCell(new Phrase("Col x1"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Col x2"));
            table.addCell(cell);
            cell = new PdfPCell(new Phrase("Col x3"));
            table.addCell(cell);
        }

        document.add(table);
    }

    @Override
    protected void setFooter() throws DocumentException {

        PdfPTable table = new PdfPTable(1);
        PdfPCell cell;
        cell = new PdfPCell(new Phrase("Footer"));
        table.addCell(cell);

        document.add(table);

        super.printDateTime("dd/MM/yyyy", "America/Sao_Paulo", "Consulta realizada em: ");
    }
}