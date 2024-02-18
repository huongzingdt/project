import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Utity {
    public static void main(String[] args) {
        updateTestcase("TC_01", "PASS");
    }
    public static void updateTestcase(String testcase, String testStatus){
        try(FileInputStream fis = new FileInputStream("fleetcart.xlsx")) {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet1 = workbook.getSheet("TestCase");

            int totalRow = sheet1.getLastRowNum() +1;
            for(int i = 0; i < totalRow; i++){
                Row row = sheet1.getRow(i);
                String ce = row.getCell(0).getStringCellValue();
                if(ce.contains(testcase)){
                    row.createCell(4).setCellValue(testStatus);
                    System.out.println("Update");
                FileOutputStream fos = new FileOutputStream("fleetcart.xlsx");
                workbook.write(fos);
                fos.close();
                break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
