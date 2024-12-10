package Queues;
public class CircularQueue<T> implements Queues<T> {
    private T[] items;
    private int front, rear, size;
    @SuppressWarnings("unchecked")
    public CircularQueue() {
        items = (T[]) new Object[2];
        front = 0;
        rear = -1;
        size = 0;
    }
    @Override
    public void enqueue(T item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        rear = (rear + 1) % items.length;
        items[rear] = item;
        size++;
    }
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = items[front];
        items[front] = null;
        front = (front + 1) % items.length;
        size--;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newArray = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = items[(front + i) % items.length];
        }
        items = newArray;
        front = 0;
        rear = size - 1;
    }
}
