public class MyLinkedList<T> {
    private Node head;
    private boolean circular;
    private boolean doubly;

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
            while (current.getNext() != null)
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
        Node fill;
        if (index == 0) {
            if (head == null) {
                head = new Node(item);
            }
            else {
                fill = head;
                head = new Node(item);
                head.setNext(fill);
                if (doubly)
                    head.setPrevious(fill.getPrevious());
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
            current.getNext().setNext(fill);
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
            if (doubly)
                current.getNext().setPrevious(current);
        }
    }
    public void clear() {
        head = null;
    }
    public boolean contains(T item) {
        if (head != null) {
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
    public T pollLast(){
        if (head == null)
            return null;
        else if (head.getNext() == null)
            return null;
        Node current = head;
        while (current.getNext().getNext() != null) {
            current = current.getNext();
        }
        Node fill = current.getNext();
        current.setNext(null);
        return fill.getData();
    }
    public T remove(int index) {
        if (head == null || index < 0)
            return null;
        Node current = head;
        if (index == 0) {
            if (head.getNext() != null) {
                head = head.getNext();
                return current.getData();
            }
            head = null;
            return current.getData();
        }
        for (int i = 1; i < index; i++) {
            if (current.getNext() == null) {
                return null;
            }
        }
        Node fill = current.getNext();
        if (current.getNext().getNext() == null) {
            current.setNext(null);
            return fill.getData();
        }
        current.setNext(fill.getNext());
        return fill.getData();

    }
    public T remove(T obj) {
        if (head == null)
            return null;
        Node current = head;
        if (head.getData().equals(obj)) {
            if (head.getNext() != null) {
                head = head.getNext();
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
        return fill.getData();
    }
    public T set(int index, T obj) {
        if (index < 0){
            return null;
        }
        if (index == 0) {
            if (head != null) {
                Node r = head;
                if (head.getNext() != null) {
                    Node fill = head.getNext();
                    head = new Node(obj);
                    head.setNext(fill);
                }
                else {
                    head.setData(obj);
                }
                return r.getData();
            }
            else {
                head = new Node(obj);
                return null;
            }
        }
        Node current = head;
        for (int i = 1; i < index - 1; i++) {
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
        }
        Node r = current.getNext();
        current.setData(obj);
        return r.getData();
    }
    public int size(){
        if (head == null){
            return 0;
        }
        int count = 1;
        Node current = head;
        while (current.getNext() != null) {
            count++;
            current = current.getNext();
        }
        return count;
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
