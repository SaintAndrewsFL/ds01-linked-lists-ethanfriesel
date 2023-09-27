import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>(false, true);
        list.add("0");
        list.add("1");
        list.add(1, "2");
        System.out.println(list.get(0));
        list.addFirst("3");
        System.out.println(list.get(0));
        System.out.println(list.get(1));

    }
}