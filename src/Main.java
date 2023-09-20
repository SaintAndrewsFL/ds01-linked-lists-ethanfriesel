import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
//        list.add("0");
//        list.add("1");
//        list.add(1, "2");
//        System.out.println(list.get(0));
//        System.out.println(list.set(0, "3"));
//        list.addLast("-1");
        System.out.println(list.indexOf("3"));
        for (int i = 0; i < 1000; i++){
            String current = String.valueOf(i);
            list.add(current);
        }
        System.out.println(list.get(500));

    }
}