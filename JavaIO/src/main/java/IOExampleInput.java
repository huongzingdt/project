import java.io.*;

public class IOExampleInput {
    public static void main(String[] args) {
        byte[] arr = new byte[100];
        try(InputStream is = new FileInputStream("student.txt")){
            is.read(arr);
            System.out.println("OK");
             String s = new String(arr);
            System.out.println(s);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
