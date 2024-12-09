package Test;
import Queues.CircularQueue;
import Queues.Queue;
import Queues.ArrayQueue;
import Queues.LinkedQueue;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("Testing ArrayQueue:");
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        testQueue(arrayQueue);

        System.out.println("\nTesting CircularQueue:");
        Queue<Integer> circularQueue = new CircularQueue<>(5);
        testQueue(circularQueue);

        System.out.println("\nTesting LinkedQueue:");
        Queue<Integer> linkedQueue = new LinkedQueue<>();
        testQueue(linkedQueue);
    }

    private static void testQueue(Queue<Integer> queue) {
        System.out.println("Enqueuing 1, 2, 3...");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Queue size after enqueuing: " + queue.size());

        System.out.println("Dequeuing element: " + queue.dequeue());

        System.out.println("Queue size after dequeuing: " + queue.size());

        System.out.println("Is the queue empty? " + queue.isEmpty());

        System.out.println("Dequeuing element: " + queue.dequeue());
        System.out.println("Dequeuing element: " + queue.dequeue());

        System.out.println("Is the queue empty? " + queue.isEmpty());

        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Caught exception (expected): " + e.getMessage());
        }
    }
}
