import java.util.Iterator; 

// creates arraylist that is circular and dynamic
public class BrowserArrayList<T> implements Iterable<T> {
    private T[] queue; 
    private int capacity; 
    private int front;
    private int rear; 
    private int size; 

    // initilaizes array, assigns random capacity
    // initializes front rear indexes 
    public BrowserArrayList() {
        this.capacity = 20;
        queue = (T[]) new Object[capacity];
        this.front = 0;
        this.rear = 0; 
        size = 0; 
    }

    //adding to front
    public void enqueue(T data) {
        if (size() == queue.length) {
            expandCapacity(); 
        }
        // assigns data to rear, iterates through modulus making it circular
        queue[rear] = data; 
        rear = (rear + 1) % queue.length; 
        size++; 
    }

    //initializes new array with double capacity
    // loops copying elements from old array to new array
    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int i = 0; i < size; i++) {
            larger[i] = queue[front];
            front = (front + 1) % queue.length; 
        }
        // reassigns front and rear indexes
        front = 0;
        rear = size;
        queue = larger; 
    }

    //removing from front
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        // assigns data to front, iterates through modulus making it circular
        T data = queue[front];
        // assigns front to null, removing it
        queue[front] = null; 
        front = (front + 1) % queue.length; 
        size--; 
        return data; 
    }

    // checks if empty
    public boolean isEmpty() {
        return size == 0; 
    }

    // returns size
    public int size() {
        return size; 
    }

    // iterator for the array, overrides from Iterable interface
    // returns an iterator object which is an anoymous internal class
    // hasNext() checks if there is a next element
    // next() uses hasnext to check next element then iterates through modulus bc its circiular and returns the next value
    // throws exception if no more elements
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = front;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size; 
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new IllegalArgumentException("No more elements");
                }
                T data = queue[current];
                current = (current + 1) % queue.length;
                count++;
                return data;
            }
        };
    }

}
