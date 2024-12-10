package CarStation;

public class GasStation implements Refuelable {

    @Override
    public void refuel(int carId) {
        System.out.println("Refueling gas car " + carId + ".");
    }

}
