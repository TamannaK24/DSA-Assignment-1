import java.util.Iterator;
import java.util.EmptyStackException;


public class BrowserLinkedList<T> implements Iterable<T> {
    public class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public BrowserLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    public T remove() {
        if (head == null) {
            throw new java.util.EmptyStackException();
        }
        T data = head.data;
        if (head == tail) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        size--;
        return data;
    }

    public T peek() {
        if (head == null) {
            throw new java.util.EmptyStackException(); 
        }
        return head.data;
    }

    public int getSize() {
        return size;
    }

    public Node<T> getTail() {
        if (tail == null) {
            return null;
        }
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            private Node<T> previous = null;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException("No more elements in the list");
                }
                previous = current;
                T data = current.data;
                current = current.next;
                if (current != null) {
                    current.prev = previous;
                }
                return data;
            }
        };
    }
}