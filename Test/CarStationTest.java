package Test;

import CarStation.*;
import Queues.ArrayQueue;

public class CarStationTest {
    public static void main(String[] args) {
        Dineable diningService = new RobotDinner();
        Refuelable electricStation = new EelctricStation();
        Refuelable gasStation = new GasStation();

        ArrayQueue<Car> carQueue = new ArrayQueue<Car>();

        CarStation carStation = new CarStation(diningService, electricStation, gasStation, carQueue);

        System.out.println("Adding cars to the CarStation...");
        carStation.addCar(new Car(1, "ELECTRIC", "ROBOTS", true, 30));
        carStation.addCar(new Car(2, "ELECTRIC", "ROBOTS", false, 20));
        carStation.addCar(new Car(3, "ELECTRIC", "PEOPLE", true, 25));
        carStation.addCar(new Car(4, "GAS", "PEOPLE", true, 25));

        System.out.println("\nServing cars in the CarStation...");
        carStation.serveCars();

        System.out.println("\nTest completed. Cars were served as follows.");
    }
}
