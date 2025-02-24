import java.util.Iterator;

// creates queue that is circular and dynamic
public class BrowserQueue<T> implements Iterable<T> {
    // creates queuee that is an array list of generic type
    private BrowserArrayList<T> queue; 

    // initializes queue as new array list
    public BrowserQueue() {
        this.queue = new BrowserArrayList<>(); 
    }

    // adds data to queue
    public void enqueue(T data) {
        queue.enqueue(data);
    }

    // removes data from queue and returns what the data is
    public T dequeue() {
        if (queue.isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return queue.dequeue();
    }

    // checks if empty
    public boolean isEmpty() {
        return queue.isEmpty(); 
    }

    // returns size of queue
    public int getSize() {
        return queue.size(); 
    }

    // creates new array list and assigns it to queue, cleaning it
    public void cleanQueue() {
        queue = new BrowserArrayList<>(); 
    }

    // returns iterator
    //loops through queuee outputing data from each index
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