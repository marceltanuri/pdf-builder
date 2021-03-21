package com.mtanuri.pdfbuilder;

public abstract class ExternalDataReport<T> extends PaginatedReport {

    protected T dataObject;

    public ExternalDataReport(T dataObject){
        this.dataObject = dataObject;
    }
}
