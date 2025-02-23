import java.util.Iterator;

public class StackIterator<T> implements Iterator<T> {
    private BrowserLinkedList<T>.Node<T> current;

    public StackIterator(BrowserLinkedList<T> stack) {
        this.current = stack.getTail(); 
    }

    @Override
    public boolean hasNext() {
        return current != null; 
    }
    
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