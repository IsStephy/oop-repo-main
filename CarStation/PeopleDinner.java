package CarStation;

public class PeopleDinner implements Dineable {
    @Override
    public void serveDinner(int carId) {
        System.out.println("Serving dinner to people in car " + carId + ".");
    }
}
