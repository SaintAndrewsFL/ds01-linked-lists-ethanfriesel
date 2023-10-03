import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>(true, true);
        list.add("0");
        list.add("1");
        list.add("3");
        list.add(2, "2");
        list.poll();
        System.out.println(list.remove("2"));
        System.out.println(list.checkCircular());
        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));

    }
}