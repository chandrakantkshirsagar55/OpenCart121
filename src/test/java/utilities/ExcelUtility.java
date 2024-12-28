package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtility {

    private String filePath; // Path to the Excel file
    private FileInputStream fis;
    private FileOutputStream fos;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private XSSFRow row;
    private XSSFCell cell;

    // Constructor to initialize the file path
    public ExcelUtility(String filePath) {
        this.filePath = filePath;
    }

    // Method to get the row count in a sheet
    public int getRowCount(String sheetName) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        workbook.close();
        fis.close();
        return rowCount;
    }

    // Method to get the cell count in a specific row
    public int getCellCount(String sheetName, int rowNum) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        int cellCount = row.getLastCellNum();
        workbook.close();
        fis.close();
        return cellCount;
    }

    // Method to get cell data as a string
    public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);
        DataFormatter formatter = new DataFormatter();
        String data = formatter.formatCellValue(cell);
        workbook.close();
        fis.close();
        return data;
    }

    // Method to set cell data
    public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException {
        fis = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);
        fos = new FileOutputStream(filePath);
        workbook.write(fos);
        workbook.close();
        fis.close();
        fos.close();
    }
}
