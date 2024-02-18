package core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {
    public static Object[][] getTableArray(String path, String sheetName, int startColm, int totalColm){
        String[][] tableArray = null;
        try{
            FileInputStream fis = new FileInputStream(path);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            int startRow = 1;
            int ci, cj;
            int totalRows = sheet.getLastRowNum();
            ci=0;
            tableArray = new String[totalRows][totalColm];

            for (int i = startRow; i <= totalRows ; i++, ci++) {
                cj=0;
                for (int j = startColm; j < totalColm ; j++, cj++) {
                    XSSFCell cell = sheet.getRow(i).getCell(j);
                    tableArray[ci][cj] = cell.getStringCellValue();
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return tableArray;
    }

}
