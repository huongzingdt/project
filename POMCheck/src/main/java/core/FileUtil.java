package core;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;

public class FileUtil {

    public static class ExcelUtil {
        public static Object[][] getTableArray(String filePath, String sheetName) throws Exception {
            // Sử dụng thư viện Apache POI để đọc file
            FileInputStream excelFile = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum();
            int colCount = sheet.getRow(0).getLastCellNum();

            Object[][] data = new Object[rowCount][colCount];
            for (int i = 1; i <= rowCount; i++) { // Bỏ qua header
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i-1][j] = row.getCell(j).toString();
                }
            }
            return data;
        }
    }
}
