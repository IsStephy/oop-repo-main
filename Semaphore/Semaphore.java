package Semaphore;

import CarStation.Car;
import CarStation.CarStation;
import CarStation.Dineable;
import CarStation.Refuelable;
import CarStation.RobotDinner;
import CarStation.EelctricStation;
import CarStation.GasStation;
import Queues.Queues;
import Queues.ArrayQueue;

import java.util.Queue;

public class Semaphore {
    public static void main(String[] args) {
        String folderPath = "oop_repo_main/queue";
        ReadJson reader = new ReadJson(folderPath);

        Queues<Car> carQueue = reader.readCarsFromJsonFiles();

        Dineable robotDiningService = new RobotDinner();
        Dineable peopleDiningService = new RobotDinner();
        Refuelable electricStation = new EelctricStation();
        Refuelable gasStation = new GasStation();

        Queues<Car> gasRobotQueue = new ArrayQueue<Car>();
        Queues<Car> gasPeopleQueue = new ArrayQueue<Car>();
        Queues<Car> electricRobotQueue = new ArrayQueue<Car>();
        Queues<Car> electricPeopleQueue = new ArrayQueue<Car>();

        CarStation gasRobotStation = new CarStation(robotDiningService, gasStation, gasRobotQueue);
        CarStation gasPeopleStation = new CarStation(peopleDiningService, gasStation, gasPeopleQueue);
        CarStation electricRobotStation = new CarStation(robotDiningService, electricStation, electricRobotQueue);
        CarStation electricPeopleStation = new CarStation(peopleDiningService, electricStation, electricPeopleQueue);

        while (!carQueue.isEmpty()) {
            Car car = carQueue.dequeue();

            if ("GAS".equalsIgnoreCase(car.getFuelType())) {
                if ("ROBOTS".equalsIgnoreCase(car.getDinnerType())) {
                    gasRobotStation.addCar(car);
                } else if ("PEOPLE".equalsIgnoreCase(car.getDinnerType())) {
                    gasPeopleStation.addCar(car);
                }
            } else if ("ELECTRIC".equalsIgnoreCase(car.getFuelType())) {
                if ("ROBOTS".equalsIgnoreCase(car.getDinnerType())) {
                    electricRobotStation.addCar(car);
                } else if ("PEOPLE".equalsIgnoreCase(car.getDinnerType())) {
                    electricPeopleStation.addCar(car);
                }
            }
        }

        gasRobotStation.serveCars();
        gasPeopleStation.serveCars();
        electricRobotStation.serveCars();
        electricPeopleStation.serveCars();
    }
}
