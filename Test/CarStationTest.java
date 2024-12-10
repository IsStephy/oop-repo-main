package Test;

import CarStation.*;
import Queues.ArrayQueue;

public class CarStationTest {
    public static void main(String[] args) {
        System.out.println("===== Test Case 1: Robot + Gas Station =====");
        Dineable robotDiningService = new RobotDinner();
        Refuelable gasStation = new GasStation();
        ArrayQueue<Car> gasCarQueue = new ArrayQueue<Car>();
        CarStation gasCarStation = new CarStation(robotDiningService, gasStation, gasCarQueue);

        gasCarStation.addCar(new Car(1, "GAS", "ROBOTS", true, 30));
        gasCarStation.addCar(new Car(2, "GAS", "ROBOTS", false, 20));
        gasCarStation.serveCars();

        System.out.println("\n===== Test Case 2: Robot + Electric Station =====");
        Refuelable electricStation = new EelctricStation();
        ArrayQueue<Car> electricCarQueue = new ArrayQueue<Car>();
        CarStation electricCarStation = new CarStation(robotDiningService, electricStation, electricCarQueue);

        electricCarStation.addCar(new Car(3, "ELECTRIC", "ROBOTS", true, 40));
        electricCarStation.addCar(new Car(4, "ELECTRIC", "ROBOTS", false, 25));
        electricCarStation.serveCars();

        System.out.println("\n===== Test Case 3: People + Gas Station =====");
        Dineable peopleDiningService = new PeopleDinner();
        ArrayQueue<Car> peopleGasCarQueue = new ArrayQueue<Car>();
        CarStation peopleGasCarStation = new CarStation(peopleDiningService, gasStation, peopleGasCarQueue);

        peopleGasCarStation.addCar(new Car(5, "GAS", "PEOPLE", true, 35));
        peopleGasCarStation.addCar(new Car(6, "GAS", "PEOPLE", false, 15));
        peopleGasCarStation.serveCars();

        System.out.println("\n===== Test Case 4: People + Electric Station =====");
        ArrayQueue<Car> peopleElectricCarQueue = new ArrayQueue<Car>();
        CarStation peopleElectricCarStation = new CarStation(peopleDiningService, electricStation, peopleElectricCarQueue);

        peopleElectricCarStation.addCar(new Car(7, "ELECTRIC", "PEOPLE", true, 50));
        peopleElectricCarStation.addCar(new Car(8, "ELECTRIC", "PEOPLE", false, 30));
        peopleElectricCarStation.serveCars();
    }
}
