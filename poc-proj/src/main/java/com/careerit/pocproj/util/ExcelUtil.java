package com.careerit.pocproj.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    public File writeDataToExcel(List<String> headers, List<List<Object>> data, String fileName, String sheetName) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        // Create header row
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
        }
        // Populate data rows
        int rowNum = 1;
        for(List<Object> row : data){
            Row dataRow = sheet.createRow(rowNum++);
            for(int i = 0; i < row.size(); i++){
                Cell cell = dataRow.createCell(i);
                Object value = row.get(i);
                if(value instanceof String){
                    cell.setCellValue((String)value);
                }else if(value instanceof Integer){
                    cell.setCellValue((Integer)value);
                }else if(value instanceof Double){
                    cell.setCellValue((Double)value);
                }else if(value instanceof Boolean){
                    cell.setCellValue((Boolean)value);
                }
            }
        }
        // Write the output to a file
        File file = new File(fileName);
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }
}