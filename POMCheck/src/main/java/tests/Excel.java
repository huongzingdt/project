package tests;

import core.Account;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static void main(String[] args) {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("account");
       List<Account> st = new ArrayList<>();
       st.add(new Account("huongdt", "dohuong8888@gmail.com", new String[] {"admin"}, true));
       st.add(new Account("dandv", "dovandan@gmail.com", new String[]{"Member"}, false));
       int countcell = 0;
       for (int i = 0; i<st.size(); i++){
           Row row = xssfSheet.createRow(i);

           Cell cell1 = row.createCell(countcell++);
           cell1.setCellValue(st.get(i).getName());

           Cell cell2 = row.createCell(countcell++);
           cell2.setCellValue(st.get(i).getEmail());

           Cell cell3 = row.createCell(countcell++);
           cell3.setCellValue(Account.torole(st.get(i).getRoles()));

           countcell = 0;
       }

       try(FileOutputStream fileOutputStream = new FileOutputStream(new File("test.xlsx"));) {
         xssfWorkbook.write(fileOutputStream);
           System.out.println("ok");
       } catch (FileNotFoundException e) {
           throw new RuntimeException(e);
       } catch (IOException e) {
           throw new RuntimeException(e);
       }

    }
}
