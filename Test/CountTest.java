package Test;

import CarStation.Car;
import CarStation.Stats;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CountTest {
    public static void main(String[] args) {
        // Create a queue of cars
        Queue<Car> carQueue = new LinkedList<>();
        carQueue.add(new Car(1, "ELECTRIC", "PEOPLE", false, 30));
        carQueue.add(new Car(2, "GAS", "PEOPLE", true, 10));
        carQueue.add(new Car(3, "ELECTRIC", "ROBOTS", true, 10));
        carQueue.add(new Car(4, "ELECTRIC", "ROBOTS", false, 13));

        HashMap<String, Object> results = Stats.stats(carQueue);


        System.out.println(results);
    }
}
