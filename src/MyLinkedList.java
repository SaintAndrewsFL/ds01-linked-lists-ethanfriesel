import org.w3c.dom.Node;

public class MyLinkedList<T> {
    private Node head;

    public MyLinkedList() {
    }

    public boolean add(T item){
        if (head == null) {
            head = new Node(item);
        }
        else {
            Node current = head;
            while (current.getNext() != null)
                current = current.next;
            current.setNext(new Node(item));
        }
        return true;
    }
    public boolean add(int index, T item){
        if (index < 0)
            return false;
        Node fill;
        if (index == 0) {
            if (head == null) {
                head = new Node(item);
            }
            else {
                fill = head.getNext();
                head = new Node(item);
                head.setNext(fill);
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
        if (current.getNext() == null)
            current.setNext(new Node(item));
        else {
            fill = current.getNext();
            current.setNext(new Node(item));
            current.getNext().setNext(new Node(fill.getData()));
        }
        return true;
    }
    public void addFirst(T item){
        if (head == null)
            head = new Node(item);
        else {
            Node fill = head;
            head = new Node(item);
            head .setNext(fill);
        }
    }
    public void addLast(T item) {
        if (head == null)
            head = new Node(item);
        else {
            Node current = head;
            while (current.getNext() != null)
                current = current.getNext();
            current.setNext(new Node(item));
        }
    }
    public void clear() {
        head = null;
    }
    public boolean contains(T item) {
        if (head == null) {
        }
        else {
            Node current = head;
            while (current != null) {
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
            if (current.getNext() == null) {
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
        while (current.getNext() != null)
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
            if (current.getData() == item)
                high = i;
            current = current.getNext();
            i++;
        }
        return high;
    }

    public T poll() {
        if (head == null || head.getNext() == null)
            return null;
        Node fill = head;
        head = head.getNext();
        return fill.getData();
    }

    public class Node{
        private Node next;
        private T data;
        public Node(T data){
            this.data = data;
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
