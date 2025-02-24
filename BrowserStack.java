import java.util.Iterator;


public class BrowserStack<T> implements Iterable<T> {
    private BrowserLinkedList<T> stack; 

    public BrowserStack() {
        this.stack = new BrowserLinkedList<>(); 
    }

    public boolean isEmpty() {
        return stack.isEmpty(); 
    }

    public void push(T data) {
        stack.add(data);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return stack.remove();
    }

    public T peek() {
        if (stack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return stack.peek(); 
    }

    public int getSize() {
        return stack.getSize(); 
    }

    public void cleanList() {
        stack = new BrowserLinkedList<>(); 
    }

    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    public void printStack() {
        for (T data : stack) {
            System.out.println(data); 
        }
    }

}