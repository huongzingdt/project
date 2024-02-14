import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonExample {
    private static ArrayList<Account> theList;
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader("jsonformatter.json")) {
            Type type = new TypeToken<ArrayList<Account>>() {
            }.getType();
            Gson gson = new Gson();
            theList = gson.fromJson(fileReader, type);
            fileReader.close();

            for (Account account : theList) {
                System.out.println(account.getName());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        public void test(){
            String data = "{\"id\":1,\"name\":\"huongdt\",\"roles\":[\"admin\",\"member\"],\"admin\":true}";
            Gson gson = new Gson();
            Account account = gson.fromJson(data, Account.class);
            System.out.println(account.getName());


            Account account1 = new Account(2, "dandv", new String[]{"admin"}, true);
            System.out.println(gson.toJson(account1));

        }

}
