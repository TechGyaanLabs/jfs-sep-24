package com.careerit.cj.day8;

public class ReportService {

    public static void showReport(ReportType reportType) {

        switch (reportType) {
            case JSON:
                jsonReport();
                break;
            case PDF:
                pdfReport();
                break;
            case CSV:
                csvReport();
                break;
            case EXCEL:
                excelReport();
                break;
            default:
                System.out.println("Unsupported report type");
        }

    }

    public static void main(String[] args) {
        showReport(ReportType.JSON);
    }

    public static void pdfReport() {
        System.out.println("PDF Report");
    }

    public static void csvReport() {
        System.out.println("CSV report");
    }

    public static void jsonReport() {
        System.out.println("JSON report");
    }

    public static void excelReport() {
        System.out.println("Excel Report");
    }
}
