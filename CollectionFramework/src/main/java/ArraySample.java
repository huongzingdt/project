import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraySample {
    public static void main(String[] args) {
        String[] arr = new String[6];
        arr[0] = "1";
        arr[1] = "2";
        arr[2] = "3";
        arr[3] = "10";

        int index = 1;
        String value = "679";
        Arrays.asList();

        for(int i = arr.length - 1; i > index; i--){
            arr[i] = arr[i-1] ;

        }
        arr[index] = value;

        for(int j = 0; j < arr.length; j++)
            System.out.println(arr[j]);

    }
}
