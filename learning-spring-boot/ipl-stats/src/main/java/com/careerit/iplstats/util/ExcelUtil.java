package com.careerit.iplstats.util;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Component
public class ExcelUtil {

    private List<String> headers;
    private List<List<Object>> data;
    private String sheetName;
    private String fileName;

    public File createExcel() {
        Workbook workbook = new XSSFWorkbook();
        if(StringUtils.isEmpty(sheetName)){
            sheetName = "Sheet1";
        }
        Sheet sheet = workbook.createSheet(sheetName);
        // Create header row
        int rowCount = 0;
        Row headerRow = sheet.createRow(rowCount++);
        for (int i = 0; i < headers.size(); i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers.get(i));
            CellStyle headerStyle = workbook.createCellStyle();
            Font font = workbook.createFont();
            font.setBold(true);
            headerStyle.setFont(font);
            cell.setCellStyle(headerStyle);
        }

        // Create data rows
        for (List<Object> rowData : data) {
            Row row = sheet.createRow(rowCount++);
            for (int i = 0; i < rowData.size(); i++) {
                Cell cell = row.createCell(i);
                Object value = rowData.get(i);
                setValue(value, cell);
            }
        }

        // Auto-size columns
        for (int i = 0; i < headers.size(); i++) {
            sheet.autoSizeColumn(i);
        }

        if(StringUtils.isEmpty(fileName)){
            fileName = System.currentTimeMillis()+"_report.xlsx";
        }
        String tempDir = System.getProperty("java.io.tmpdir");
        // Write to file
        fileName = tempDir + fileName;
        File file = new File(fileName);
        try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
        } catch (IOException e) {
            System.out.println("Error while writing to file: "+ e.getMessage());
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                System.out.println("Error while closing workbook: "+ e.getMessage());
            }
        }
        return file;
    }

    private static void setValue(Object value, Cell cell) {
        if (value instanceof String) {
            cell.setCellValue((String) value);
        } else if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Double) {
            cell.setCellValue((Double) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Long) {
            cell.setCellValue((Long) value);
        }
    }

}
