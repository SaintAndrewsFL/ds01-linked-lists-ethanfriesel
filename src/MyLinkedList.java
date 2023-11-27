import java.util.LinkedList;

public class MyLinkedList<T> {
    private Node head;
    private boolean circular;
    private boolean doubly;

    public MyLinkedList() {
    }
    public MyLinkedList(boolean circular, boolean doubly) {
        this.circular = circular;
        this.doubly = doubly;
    }

    public void add(T item){
        if (head == null) {
            head = new Node(item);
        }
        else {
            Node current = head;
            while (current.getNext() != null && current.getNext() != head)
                current = current.next;
            current.setNext(new Node(item));
            if (circular)
                current.getNext().setNext(head);
            if (doubly)
                current.getNext().setPrevious(current);
            if (doubly && circular)
                head.setPrevious(current.getNext());
        }
    }
    public boolean add(int index, T item){
        if (index < 0)
            return false;
        T fill;
        if (index == 0) {
            if (head == null) {
                head = new Node(item);
            }
            else {
                fill = head.getData();
                Node next = head.getNext();
                head.setNext(new Node(fill));
                head.getNext().setNext(next);
                head.setData(item);
                if (doubly) {
                    head.getNext().setPrevious(head);
                    head.getNext().getNext().setPrevious(head.getNext());
                }
            }
            return true;
        }
        if (head == null)
            return false;
        Node current = head;
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null)
                return false;
            current = current.getNext();
        }
        if (current.getNext() == null) {
            current.setNext(new Node(item));
            if (circular)
                current.getNext().setNext(head);
            if (doubly) {
                current.getNext().setPrevious(current);
                head.setPrevious(current.getNext());
            }
        }
        else {
            Node next = current.getNext();
            current.setNext(new Node(item));
            current.getNext().setNext(next);
            if (doubly) {
                current.getNext().setPrevious(current);
                current.getNext().getNext().setPrevious(current.getNext());
            }
        }
        return true;
    }
    public void addFirst(T item){
        if (head == null)
            head = new Node(item);
        else {
            T fill = head.getData();
            head.setData(item);
            Node next = head.getNext();
            head.setNext(new Node(fill));
            head.getNext().setNext(next);
            if (doubly)
                head.getNext().setPrevious(head);
        }
    }
    public void addLast(T item) {
        if (head == null)
            head = new Node(item);
        else {
            Node current = head;
            while (current.getNext() != head)
                current = current.getNext();
            current.setNext(new Node(item));
            if (circular)
                current.getNext().setNext(head);
            if (doubly) {
                current.getNext().setPrevious(current);
                head.setPrevious(current.getNext());
            }
        }
    }
    public void clear() {
        head = null;
    }
    public boolean contains(T item) {
        if (head != null) {
            Node current = head;
            while (current != null || current.getNext().equals(head)) {
                if (current.getData().equals(item))
                    return true;
                current = current.getNext();
            }
        }
        return false;
    }
    public T get(int index) {
        if (head == null || index < 0) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current.getNext() == null || current.getNext() == head) {
                return null;
            }
            current = current.getNext();
        }
        return current.getData();

    }
    public T getFirst() {
        if (head == null)
            return null;
        return head.getData();
    }
    public T getLast() {
        if (head == null)
            return null;
        Node current = head;
        while (current.getNext() != null && current.getNext() != head)
            current = current.getNext();
        return current.getData();
    }
    public int indexOf(T item) {
        if (head == null)
            return -1;
        Node current = head;
        int i = 0;
        while (current != null){
            if (current.getData() == item)
                return i;
            if (current.getNext() == head)
                return -1;
            current = current.getNext();
            i++;
        }
        return -1;
    }
    public int lastIndexOf(T item) {
        if (head == null)
            return -1;
        Node current = head;
        int i = 0;
        int high = -1;
        while (current != null){
            if (current.getData().equals(item))
                high = i;
            current = current.getNext();
            if (current == head)
                return high;
            i++;
        }
        return high;
    }

    public T poll() {
        if (head == null || head.getNext() == null)
            return null;
        T data = head.getData();
        T fill = head.getNext().getData();
        head.setNext(head.getNext().getNext());
        head.setData(fill);
        return data;
    }
    public T pollLast(){
        if (head == null)
            return null;
        else if (head.getNext() == null) {
            T fill = head.getData();
            head = null;
            return fill;
        }
        Node current = head;
        while (current.getNext().getNext() != null && current.getNext().getNext() != head) {
            current = current.getNext();
        }
        Node fill = current.getNext();
        if (circular)
            current.setNext(head);
        else
            current.setNext(null);
        return fill.getData();
    }
    public T remove(int index) {
        if (head == null || index < 0)
            return null;
        Node current = head;
        if (index == 0) {
            if (head.getNext() != null) {
                T fill = head.getNext().getData();
                head.setNext(head.getNext().getNext());
                head.setData(fill);
                if (doubly)
                    head.getNext().setPrevious(head);
                return current.getData();
            }
            head = null;
            return current.getData();
        }
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        Node fill = current.getNext();
        if (current.getNext().getNext() == null) {
            current.setNext(null);
            return fill.getData();
        }
        current.setNext(fill.getNext());
        if (doubly)
            current.getNext().setPrevious(current);
        return fill.getData();

    }
    public T remove(T obj) {
        if (head == null)
            return null;
        Node current = head;
        if (head.getData().equals(obj)) {
            if (head.getNext() != null) {
                head = head.getNext();
                if (doubly)
                    head.getNext().setPrevious(head);
                return current.getData();
            }
            head = null;
            return current.getData();
        }
        if (current.getNext() == null) {
            return null;
        }
        while (!current.getNext().getData().equals(obj)){
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        Node fill = current.getNext();
        if (current.getNext().getNext() == null) {
            current.setNext(null);
            return fill.getData();
        }
        current.setNext(fill.getNext());
        if (doubly)
            current.getNext().setPrevious(current);
        return fill.getData();
    }
    public T set(int index, T obj) {
        if (index < 0){
            return null;
        }
        if (head == null){
            head = new Node(obj);
            return null;
        }
        if (index == 0) {
            T fill = head.getData();
            head.setData(obj);
            return fill;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
           if (current.getNext() == null || current.getNext() == head)
               return null;
           current = current.getNext();
        }
        if (current.getNext() == null || current.getNext() == head) {
            current.setNext(new Node(obj));
            if (circular)
                current.getNext().setNext(head);
            if (doubly)
                current.getNext().setPrevious(current);
            return null;
        }
        T fill = current.getNext().getData();
        current.getNext().setData(obj);
        return fill;
    }
    public int size(){
        if (head == null){
            return 0;
        }
        int count = 1;
        Node current = head;
        while (current.getNext() != null && current.getNext() != head) {
            count++;
            current = current.getNext();
        }
        return count;
    }
    public boolean checkCircular() {
        if (head == null)
            return false;
        Node turtle = head;
        if (turtle.getNext() == null)
            return false;
        Node rabbit = turtle.getNext();
        while (turtle != rabbit) {
            turtle = turtle.getNext();
            rabbit = rabbit.getNext();
            if (rabbit == null)
                return false;
            rabbit = rabbit.getNext();
            if (turtle == null || rabbit == null)
                return false;
        }
        return true;
    }




    public class Node{
        private Node previous;
        private Node next;
        private T data;
        public Node(T data){
            this.data = data;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
