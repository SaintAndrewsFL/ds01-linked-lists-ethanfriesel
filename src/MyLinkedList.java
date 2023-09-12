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
        Node current = head;
        for (int i = 0; i < index; i++) {
            if (current == null)
                return false;
        }
        Node fill;
        if (current != null || current.getNext() != null) {
            fill = current.getNext();
            current.setNext(new Node(item));
            current.getNext().setNext(new Node(fill.getData()));
        }
        else
            current.setNext(new Node(item));
        return true;
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
