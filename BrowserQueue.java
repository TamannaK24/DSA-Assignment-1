import java.util.Iterator;

public class BrowserQueue<T> implements Iterable<T> {
    private BrowserArrayList<T> queue; 

    public BrowserQueue() {
        this.queue = new BrowserArrayList<>(); 
    }

    public void enqueue(T data) {
        queue.enqueue(data);
    }
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return queue.dequeue();
    }

    public boolean isEmpty() {
        return queue.isEmpty(); 
    }

    public int getSize() {
        return queue.size(); 
    }

    public void cleanQueue() {
        queue = new BrowserArrayList<>(); 
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    public void printQueue() {
        for (T data : queue) {
            System.out.println(data); 
        }
    }
}