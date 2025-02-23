import java.util.Iterator; 

public class BrowserArrayList<T> implements Iterable<T> {
    private T[] queue; 
    private int capacity; 
    private int front;
    private int rear; 
    private int size; 

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
        queue[rear] = data; 
        rear = (rear + 1) % queue.length; 
        size++; 
    }

    public void expandCapacity() {
        T[] larger = (T[]) (new Object[queue.length * 2]);
        for (int i = 0; i < size; i++) {
            larger[i] = queue[front];
            front = (front + 1) % queue.length; 
        }
        front = 0;
        rear = size;
        queue = larger; 
    }

    //removing from front
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        T data = queue[front];
        queue[front] = null; 
        front = (front + 1) % queue.length; 
        size--; 
        return data; 
    }

    public boolean isEmpty() {
        return size == 0; 
    }

    public int size() {
        return size; 
    }

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
