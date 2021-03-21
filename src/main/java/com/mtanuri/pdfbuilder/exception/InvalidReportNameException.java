package com.mtanuri.pdfbuilder.exception;

public class InvalidReportNameException extends Exception{

    public InvalidReportNameException() {
    }

    public InvalidReportNameException(String msg) {
        super(msg);
    }

    public InvalidReportNameException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public InvalidReportNameException(Throwable cause) {
        super(cause);
    }

}
