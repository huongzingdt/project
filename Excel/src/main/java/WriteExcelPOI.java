import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExcelPOI {
    public static void main(String[] args) {

        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();
        XSSFSheet xssfSheet = xssfWorkbook.createSheet("account");

        List<Account> ls = new ArrayList<Account>();
        ls.add(new Account("huongdt", "abc@gmail.com", "097886554", new String[]{"admin"}, true));
        ls.add(new Account("dandv", "abc@gmail.com","0231574", new String[]{"member"}, false));

        int countCell = 0;
        for(int i = 0; i < ls.size(); i++){
            Row row = xssfSheet.createRow(i);

            Cell cell1 = row.createCell(countCell++);
            cell1.setCellValue(ls.get(i).getUsername());

            Cell cell2 = row.createCell(countCell++);
            cell2.setCellValue(ls.get(i).getEmail());

            Cell cell3 = row.createCell(countCell++);
            cell3.setCellValue(ls.get(i).getMobile());

            countCell = 0;
        }

        try(FileOutputStream fos = new FileOutputStream("test.xlsx")){
            xssfWorkbook.write(fos);
            System.out.println("DONE");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
