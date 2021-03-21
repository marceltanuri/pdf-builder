package com.mtanuri.pdfbuilder.factory;

import com.mtanuri.pdfbuilder.Report;
import com.mtanuri.pdfbuilder.exception.InvalidReportNameException;
import com.mtanuri.pdfbuilder.impl.AnalyticalTimesheetReportForMultipleEmployeesImpl;
import com.mtanuri.pdfbuilder.impl.DemoExternalDataReportImpl;
import com.mtanuri.pdfbuilder.impl.DemoPaginatedReportImpl;
import com.mtanuri.pdfbuilder.impl.DemoReportImpl;
import com.mtanuri.pdfbuilder.model.DemoDTO;

public class ReportFactoryUtil {
    public static Report create(String reportName) throws Exception {
        if ("demo".equals(reportName)){
            return new DemoReportImpl();
        }
        if ("paginationDemo".equals(reportName)){
            return new DemoPaginatedReportImpl();
        }
        if ("external-data-demo".equals(reportName)){
            return new DemoExternalDataReportImpl(new DemoDTO());
        }
        if ("timesheet_multi_employees".equals(reportName)){
            return new AnalyticalTimesheetReportForMultipleEmployeesImpl();
        }
        throw new InvalidReportNameException("Invalid reportName");
    }
}
