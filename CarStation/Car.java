package CarStation;

public class Car {
    private int id;
    private String fuelType;
    private String dinnerType;
    private boolean isDining;
    private int consumptionRate;

    public Car(int id, String fuelType, String dinnerType, boolean isDining, int consumptionRate) {
        this.id = id;
        this.fuelType = fuelType;
        this.dinnerType = dinnerType;
        this.isDining = isDining;
        this.consumptionRate = consumptionRate;
    }

    public int getCarId() {
        return id;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getDinnerType() {
        return dinnerType;
    }

    public boolean isDining() {
        return isDining;
    }

    public int getConsumption() {
        return consumptionRate;
    }


}
