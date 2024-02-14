import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputObject {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("account.txt")) {
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
