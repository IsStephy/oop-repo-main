package CarStation;

public class RobotDinner implements Dineable {
    private int Robots = 0;
    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to Robot in car " + carId + ".");
        Robots++;
    }
    public int getRobotsNumber(){
        return Robots;
    }
}
