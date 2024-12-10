package Queues;
public interface Queues<T> {
    void enqueue(T item);
    T dequeue();
    boolean isEmpty();
    int size();
}