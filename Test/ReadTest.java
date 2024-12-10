package Test;

import CarStation.Car;
import CarStation.Stats;
import Queues.Queues;
import Queues.ArrayQueue;
import Semaphore.ReadJson;

import java.util.HashMap;

public class ReadTest {
    public static void main(String[] args) {
        String folderPath = "oop_repo_main/queue";
        ReadJson reader = new ReadJson(folderPath);

        System.out.println("Reading cars from JSON files...");
        Queues<Car> carQueue = reader.readCarsFromJsonFiles();

        Queues<Car> tempQueue = new ArrayQueue<Car>();

        System.out.println("\nCars in queue:");
        while (!carQueue.isEmpty()) {
            Car car = carQueue.dequeue();
            tempQueue.enqueue(car);
            System.out.println("Car ID: " + car.getCarId() + ", Type: " + car.getFuelType() + ", Passengers: " + car.getDinnerType() + ", Is Dining: " + car.isDining() + ", Consumption: " + car.getConsumption());
        }


        while (!tempQueue.isEmpty()) {
            carQueue.enqueue(tempQueue.dequeue());
        }


        System.out.println("\nStats:");
        HashMap<String, Object> stats = Stats.stats(carQueue);
        System.out.println(stats);
    }
}
