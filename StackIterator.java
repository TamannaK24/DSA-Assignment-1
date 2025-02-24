import java.util.Iterator;

//iterates through linked list, the opposite way from tail to head overriding iterator interface
public class StackIterator<T> implements Iterator<T> {
    // creates node for current of generic type through linked list class and node class
    private BrowserLinkedList<T>.Node<T> current;

    // initializes current as tail
    public StackIterator(BrowserLinkedList<T> stack) {
        this.current = stack.getTail();
    }

    // checks if there is a next element
    @Override
    public boolean hasNext() {
        return current != null;
    }

    // if there is not next element aka it is the tail
    // then it throws an exception and returns the tail
    // by calling next repetitively, the iterator moves one node at a time towards head
    @Override
    public T next() {
        if (!hasNext()) {
            throw new IllegalArgumentException("No more elements in the list");
        }
        T data = current.data;
        current = current.prev;
        return data;
    }
}