package CarStation;

public class RobotDinner implements Dineable {
    @Override
    public void serveDinner(int carId) {
        System.out.println("Serving dinner to Robot in car " + carId + ".");
    }
}
