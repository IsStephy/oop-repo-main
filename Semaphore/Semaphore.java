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
import CarStation.Stats;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Semaphore {

    private static ExecutorService executorService = Executors.newFixedThreadPool(2);
    private static boolean stopRequested = false;

    public static void main(String[] args) {
        String folderPath = "oop_repo_main/queue";
        ReadJson reader = new ReadJson(folderPath);

        Dineable robotDiningService = new RobotDinner();
        Dineable peopleDiningService = new RobotDinner();
        Refuelable electricStation = new EelctricStation();
        Refuelable gasStation = new GasStation();

        Queues<Car> Queue = new ArrayQueue<Car>();

        Queues<Car> gasRobotQueue = new ArrayQueue<Car>();
        Queues<Car> gasPeopleQueue = new ArrayQueue<Car>();
        Queues<Car> electricRobotQueue = new ArrayQueue<Car>();
        Queues<Car> electricPeopleQueue = new ArrayQueue<Car>();

        CarStation gasRobotStation = new CarStation(robotDiningService, gasStation, gasRobotQueue);
        CarStation gasPeopleStation = new CarStation(peopleDiningService, gasStation, gasPeopleQueue);
        CarStation electricRobotStation = new CarStation(robotDiningService, electricStation, electricRobotQueue);
        CarStation electricPeopleStation = new CarStation(peopleDiningService, electricStation, electricPeopleQueue);


        executorService.submit(() -> {
            Timer readTimer = new Timer();
            readTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (stopRequested) {
                        cancel();
                        return;
                    }

                    File file = reader.getNextFile();
                    if (file != null) {
                        Car car = reader.readCarFromJsonFile(file);

                        if ("GAS".equalsIgnoreCase(car.getFuelType())) {
                            if ("ROBOTS".equalsIgnoreCase(car.getDinnerType())) {
                                gasRobotStation.addCar(car);
                                Queue.enqueue(car);
                            } else if ("PEOPLE".equalsIgnoreCase(car.getDinnerType())) {
                                gasPeopleStation.addCar(car);
                                Queue.enqueue(car);
                            }
                        } else if ("ELECTRIC".equalsIgnoreCase(car.getFuelType())) {
                            if ("ROBOTS".equalsIgnoreCase(car.getDinnerType())) {
                                electricRobotStation.addCar(car);
                                Queue.enqueue(car);
                            } else if ("PEOPLE".equalsIgnoreCase(car.getDinnerType())) {
                                electricPeopleStation.addCar(car);
                                Queue.enqueue(car);
                            }
                        }
                    }
                }
            }, 0, 2000);
        });

        executorService.submit(() -> {
            Timer serveTimer = new Timer();
            serveTimer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    if (stopRequested) {
                        cancel();
                        return;
                    }

                    gasRobotStation.serveCars();
                    if (gasPeopleStation != null) {
                        System.out.println("\n");
                    }
                    gasPeopleStation.serveCars();
                    if (electricRobotStation != null) {
                        System.out.println("\n");
                    }
                    electricRobotStation.serveCars();
                    if (electricPeopleStation != null) {
                        System.out.println("\n");
                    }
                    electricPeopleStation.serveCars();
                }
            }, 0, 4000);
        });

        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (!stopRequested) {
                String input = scanner.nextLine();
                if ("q".equalsIgnoreCase(input)) {
                    HashMap<String, Object> results = Stats.stats(Queue);
                    System.out.println("Stats at the time of stopping: " + results);
                    stopRequested = true;
                    executorService.shutdown();
                    break;
                }
            }
        });

        inputThread.start();
    }


}
