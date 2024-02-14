import java.io.*;

public class InputObject {

    public static void main(String[] args) {
      Account account = new Account("test", "check", "check@gmail.com");
     boolean check =   writeOb(account,  "account.txt");
     if(check){
         System.out.println("OK");
     } else
     {
         System.out.println("ERROR");
     }

        Account account1 = (Account) readOb("account.txt");
        account1.display();

    }
    public static boolean writeOb(Object data, String path)
    {
        File file = new File(path);
        if(!file.exists()) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        try(FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos))
    {
        oos.writeObject(data);
        return true;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
      return false;
    }

    public static Object readOb(String path){
            try(FileInputStream fis = new FileInputStream(path);
                 ObjectInputStream ois = new ObjectInputStream(fis)){
              return ois.readObject();
        } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
//            return null;
    }
}
