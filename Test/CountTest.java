package Test;

import Queues.ArrayQueue;
import Queues.Queues;
import CarStation.Car;
import CarStation.Stats;
import java.util.HashMap;

public class CountTest {

    private static void runTests() {
        testStatsWithEmptyQueue();
        testStatsWithSampleData();
        testStatsWithNoDiningCars();
        testStatsWithDifferentFuelTypes();
    }

    private static void testStatsWithEmptyQueue() {
        Queues<Car> carQueue = new ArrayQueue<Car>();

        HashMap<String, Object> stats = Stats.stats(carQueue);

        assert ((int) stats.get("ELECTRIC")) == 0 : "Failed: Electric count should be 0";
        assert ((int) stats.get("GAS")) == 0 : "Failed: Gas count should be 0";
        assert ((int) stats.get("PEOPLE")) == 0 : "Failed: People count should be 0";
        assert ((int) stats.get("ROBOTS")) == 0 : "Failed: Robots count should be 0";
        assert ((int) stats.get("DINING")) == 0 : "Failed: Dining count should be 0";
        assert ((int) stats.get("NOT_DINING")) == 0 : "Failed: Not dining count should be 0";

        HashMap<String, Integer> consumption = (HashMap<String, Integer>) stats.get("CONSUMPTION");
        assert consumption.get("ELECTRIC") == 0 : "Failed: Electric consumption should be 0";
        assert consumption.get("GAS") == 0 : "Failed: Gas consumption should be 0";

        System.out.println("testStatsWithEmptyQueue passed.");
    }

    private static void testStatsWithSampleData() {
        Queues<Car> carQueue = new ArrayQueue<Car>();
        carQueue.enqueue(new Car(1, "GAS", "PEOPLE", true, 50));
        carQueue.enqueue(new Car(2, "ELECTRIC", "ROBOTS", false, 30));
        carQueue.enqueue(new Car(3, "GAS", "PEOPLE", false, 40));
        carQueue.enqueue(new Car(4, "GAS", "ROBOTS", true, 60));
        carQueue.enqueue(new Car(5, "ELECTRIC", "PEOPLE", true, 20));

        HashMap<String, Object> stats = Stats.stats(carQueue);

        assert ((int) stats.get("ELECTRIC")) == 2 : "Failed: Electric count should be 2";
        assert ((int) stats.get("GAS")) == 3 : "Failed: Gas count should be 3";
        assert ((int) stats.get("PEOPLE")) == 3 : "Failed: People count should be 3";
        assert ((int) stats.get("ROBOTS")) == 2 : "Failed: Robots count should be 2";
        assert ((int) stats.get("DINING")) == 3 : "Failed: Dining count should be 3";
        assert ((int) stats.get("NOT_DINING")) == 2 : "Failed: Not dining count should be 2";

        HashMap<String, Integer> consumption = (HashMap<String, Integer>) stats.get("CONSUMPTION");
        assert consumption.get("ELECTRIC") == 50 : "Failed: Electric consumption should be 50";
        assert consumption.get("GAS") == 150 : "Failed: Gas consumption should be 150";

        System.out.println("testStatsWithSampleData passed.");
    }

    private static void testStatsWithNoDiningCars() {
        Queues<Car> carQueue = new ArrayQueue<Car>();
        carQueue.enqueue(new Car(1, "GAS", "PEOPLE", false, 50));
        carQueue.enqueue(new Car(2, "ELECTRIC", "ROBOTS", false, 30));
        carQueue.enqueue(new Car(3, "GAS", "PEOPLE", false, 40));
        carQueue.enqueue(new Car(4, "GAS", "ROBOTS", false, 60));
        carQueue.enqueue(new Car(5, "ELECTRIC", "PEOPLE", false, 20));

        HashMap<String, Object> stats = Stats.stats(carQueue);

        assert ((int) stats.get("DINING")) == 0 : "Failed: Dining count should be 0";
        assert ((int) stats.get("NOT_DINING")) == 5 : "Failed: Not dining count should be 5";

        System.out.println("testStatsWithNoDiningCars passed.");
    }

    private static void testStatsWithDifferentFuelTypes() {
        Queues<Car> carQueue = new ArrayQueue<Car>();
        carQueue.enqueue(new Car(1, "GAS", "PEOPLE", true, 50));
        carQueue.enqueue(new Car(2, "ELECTRIC", "ROBOTS", false, 30));

        HashMap<String, Object> stats = Stats.stats(carQueue);

        assert ((int) stats.get("ELECTRIC")) == 1 : "Failed: Electric count should be 1";
        assert ((int) stats.get("GAS")) == 1 : "Failed: Gas count should be 1";
        assert ((int) stats.get("PEOPLE")) == 1 : "Failed: People count should be 1";
        assert ((int) stats.get("ROBOTS")) == 1 : "Failed: Robots count should be 1";

        HashMap<String, Integer> consumption = (HashMap<String, Integer>) stats.get("CONSUMPTION");
        assert consumption.get("GAS") == 50 : "Failed: Gas consumption should be 50";
        assert consumption.get("ELECTRIC") == 30 : "Failed: Electric consumption should be 30";

        System.out.println("testStatsWithDifferentFuelTypes passed.");
    }

    public static void main(String[] args) {
        runTests();
    }
}
