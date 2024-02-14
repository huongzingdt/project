package tests;

import com.google.gson.Gson;
import core.Account;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Formattable;
import java.util.List;

public class Json {
    public static void main(String[] args) {
        Gson gson = new Gson();
         String json = "[{\"name\":\"huongdt\",\"email\":\"abdcd@gmail.com\",\"roles\":[\"admin\"],\"admin\":true}, {\"name\":\"huongdt1\",\"email\":\"abdcd23454@gmail.com\",\"roles\":[\"admin\", \"member\"],\"admin\":true}]";
         Account[] arr = gson.fromJson(json, Account[].class);
         List<Account> accounts = Arrays.asList(arr);
         for(Account account: accounts){
             System.out.println(account.toString());
         }
    }
}
