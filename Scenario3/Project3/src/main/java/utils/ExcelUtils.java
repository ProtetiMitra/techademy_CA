package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private Workbook workbook;
    private Sheet sheet;

    public ExcelUtils(String filePath, String sheetName) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            workbook = new XSSFWorkbook(fileInputStream);
            sheet = workbook.getSheet(sheetName);

            if (sheet == null) {
                throw new RuntimeException("Sheet: " + sheetName + " not found in " + filePath);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load Excel file: " + filePath, e);
        }
    }

    public int getRowCount() {
        return sheet.getPhysicalNumberOfRows();
    }

    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) return null;
        Cell cell = row.getCell(colNum);
        if (cell == null) return null;
        return cell.toString();
    }
}
