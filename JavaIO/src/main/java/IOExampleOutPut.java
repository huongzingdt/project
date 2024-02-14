import java.io.*;
public class IOExampleOutPut {
    public static void main(String[] args) {
        String data = "new lease on life";

        try(OutputStream os = new FileOutputStream("test.txt")){
            byte[] arr = data.getBytes();
            os.write(arr);
            System.out.println("OK jiji");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
