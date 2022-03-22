package boom;

import java.util.Arrays;

public class CircularQueue<E> {

    public static void main(String... args) {
        CircularQueue<Integer> circularQueue = new CircularQueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);

        System.out.println("Full Circular Queue" + circularQueue);

        System.out.print("Dequeued following element from circular Queue ");
        System.out.println(circularQueue.dequeue() + " ");
        circularQueue.enqueue(23);
        System.out.println("After enqueueing circular queue with element having value 23");
        System.out.println(circularQueue);
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        System.out.println(circularQueue);

    }

    int front, rear;
    private int currentSize;
    private E[] elements;
    private int maxSize;

    CircularQueue(int maxSize){
        this.maxSize = maxSize;
        elements = (E[]) new Object[this.maxSize];
        currentSize = 0;
         rear = -1; front = -1;
    }

    //Enqueue elements to front
    public void enqueue(E item){
        if(isFull()) {
            throw new QueueFullException("Fail. Queue is full!");
        }
        else {
            rear = (rear + 1) % maxSize;
            elements[rear] = item;
            currentSize++;

            if(front==-1) front = rear;

        }

    }

    public  E dequeue() {
        E deqElement;
        if(isEmpty()) {
            throw new QueueEmptyException("Queue is empty!");
        }
        else {
            deqElement = elements[front];
            elements[front] = null;
            front = (front+1) % maxSize;
            currentSize--;
        }
        return deqElement;
    }

    private boolean isEmpty() {
        return currentSize == 0;
    }

    private boolean isFull() {
        return currentSize == maxSize;
    }

    public String toString() {
        return "CircularQueue [" + Arrays.toString(elements) + "]";
    }

}

class QueueFullException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QueueFullException() {
        super();
    }

    public QueueFullException(String message) {
        super(message);
    }

}

class QueueEmptyException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public QueueEmptyException() {
        super();
    }

    public QueueEmptyException(String message) {
        super(message);
    }

}