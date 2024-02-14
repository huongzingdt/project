import java.util.ArrayList;
import java.util.List;

public class ListCol {
    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<>();
        ls.add(2);
        ls.add(3);
        ls.add(9);
        ls.get(1);
        ls.toArray();
//
//        for(int i = 1; i < ls.size(); i++){
//            System.out.println(ls.get(i));
//        }
//
//        for(Integer i: ls){
//            System.out.println(i);
//        }

        ls.set(0, 56);
        ls.remove(1);



        for(int i = ls.size() - 1; i >=0; i--){
            System.out.println(ls.get(i));
        }
    }
}
