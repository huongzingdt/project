package tests;

import java.io.*;

public class JavaIO {
    public static void main(String[] args) {
        Student st = new Student();
        st.input();
       boolean check =  writeOb(st, "newStudent.txt");
       if (check)
           System.out.println("success");
       else
           System.out.println("not success");

       Student s = (Student) readOb("newStudent.txt");
       s.display();
    }
    public static boolean writeOb(Object data, String path){


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
                ObjectInputStream ois = new ObjectInputStream(fis))  {
          return ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
