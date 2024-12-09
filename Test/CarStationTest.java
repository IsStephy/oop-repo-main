package Test;
import CarStation.*;

public class CarStationTest {
    public static void main(String[] args) {
        System.out.println("Testing Electric Station:");
        Refuelable electricStation = new EelctricStation();
        electricStation.refuel("Car_1");
        electricStation.refuel("Car_2");

        System.out.println("\nTesting Gas Station:");
        Refuelable gasStation = new GasStation();
        gasStation.refuel("Car_3");
        gasStation.refuel("Car_4");

        System.out.println("\nTesting People Dinner:");
        Dineable peopleDinner = new PeopleDinner();
        peopleDinner.serveDinner("Car_5");
        peopleDinner.serveDinner("Car_6");

        System.out.println("\nTesting Robot Dinner:");
        Dineable robotDinner = new RobotDinner();
        robotDinner.serveDinner("Car_7");
        robotDinner.serveDinner("Car_8");
        robotDinner.serveDinner("Car_9");
    }
}
