package CarStation;

public class PeopleDinner implements Dineable {
    private int people = 0;
    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to people in car " + carId + ".");
        people++;
    }
    public int GetPeopleNumber(){
        return people;
    }
}
