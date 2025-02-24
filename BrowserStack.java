import java.util.Iterator;

public class BrowserStack<T> implements Iterable<T> {
    private BrowserLinkedList<T> stack; 

    // initializes stack as new linked list
    public BrowserStack() {
        this.stack = new BrowserLinkedList<>(); 
    }

    // checks if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty(); 
    }

    // adds data to stack
    public void push(T data) {
        stack.add(data);
    }

    // removes data from stack and returns what the data is
    public T pop() {
        if (stack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return stack.remove();
    }

    // checks if empty, if not returns the first element of the list
    public T peek() {
        if (stack.isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return stack.peek(); 
    }

    // returns size of stack
    public int getSize() {
        return stack.getSize(); 
    }

    // creates new linked list and assigns it to stack, cleaning it
    public void cleanList() {
        stack = new BrowserLinkedList<>(); 
    }

    // returns iterator
    @Override
    public Iterator<T> iterator() {
        return stack.iterator();
    }

    // prints stack by looping through it and outputing data from each node
    public void printStack() {
        for (T data : stack) {
            System.out.println(data); 
        }
    }

}