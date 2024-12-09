package CarStation;

public class EelctricStation implements Refuelable {

    @Override
    public void refuel(String carId) {
        System.out.println("Refueling Electric car " + carId + ".");
    }
}