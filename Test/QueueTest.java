package Test;
import Queues.CircularQueue;
import Queues.Queues;
import Queues.ArrayQueue;
import Queues.LinkedQueue;

public class QueueTest {
    public static void main(String[] args) {
        System.out.println("Testing ArrayQueue:");
        Queues<Integer> arrayQueue = new ArrayQueue<Integer>();
        testQueue(arrayQueue);

        System.out.println("\nTesting CircularQueue:");
        Queues<Integer> circularQueue = new CircularQueue<Integer>(5);
        testQueue(circularQueue);

        System.out.println("\nTesting LinkedQueue:");
        Queues<Integer> linkedQueue = new LinkedQueue<Integer>();
        testQueue(linkedQueue);
    }

    private static void testQueue(Queues<Integer> queue) {
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
