import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        System.out.println(list.add(0));
        list.add(1);
        list.add(1, 2);
        System.out.println(list.contains(0));
        System.out.println(list.indexOf(50));
    }
}