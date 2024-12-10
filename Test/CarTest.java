package Test;
import CarStation.*;

public class CarTest {
    public static void main(String[] args) {
        System.out.println("Testing Electric Station:");
        Refuelable electricStation = new EelctricStation();
        electricStation.refuel(1);
        electricStation.refuel(2);

        System.out.println("\nTesting Gas Station:");
        Refuelable gasStation = new GasStation();
        gasStation.refuel(3);
        gasStation.refuel(4);

        System.out.println("\nTesting People Dinner:");
        Dineable peopleDinner = new PeopleDinner();
        peopleDinner.serveDinner(5);
        peopleDinner.serveDinner(6);

        System.out.println("\nTesting Robot Dinner:");
        Dineable robotDinner = new RobotDinner();
        robotDinner.serveDinner(7);
        robotDinner.serveDinner(8);
        robotDinner.serveDinner(9);
    }
}
