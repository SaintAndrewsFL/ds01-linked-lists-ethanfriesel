import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList<>();
        for(int i = 0; i < 10; i++) {
            myLinkedList.add(""+i);
        }
        myLinkedList.set(1,"new"); //this makes the head set to "new"
        myLinkedList.set(5,"new"); //this sets node 3 to "new"
        for (int i = 0; i < 10; i++)
            System.out.println(myLinkedList.get(i));
//        MyLinkedList<String> list = new MyLinkedList<>(true, true);
//        list.add("0");
//        list.add("1");
//        list.add("3");
//        list.add(2, "2");
//        System.out.println(list.set(0, "1"));
//        System.out.println();
//        System.out.println(list.get(0));
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(3));

    }
}