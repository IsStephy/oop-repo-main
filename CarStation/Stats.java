package CarStation;

import java.util.Queue;
import java.util.HashMap;

public class Stats {
    public static HashMap<String, Object> stats(Queue<Car> carQueue) {
        int electricCount = 0;
        int gasCount = 0;
        int peopleCount = 0;
        int robotsCount = 0;
        int diningCount = 0;
        int notDiningCount = 0;
        int electricConsumption = 0;
        int gasConsumption = 0;

        for (Car car : carQueue) {
            if ("ELECTRIC".equals(car.getFuelType())) {
                electricCount++;
                electricConsumption += car.getConsumption();
            } else if ("GAS".equals(car.getFuelType())) {
                gasCount++;
                gasConsumption += car.getConsumption();
            }

            if (car.isDining()) {
                diningCount++;
            } else {
                notDiningCount++;
            }

            if ("PEOPLE".equals(car.getDinnerType())) {
                peopleCount++;
            } else if ("ROBOTS".equals(car.getDinnerType())) {
                robotsCount++;
            }
        }

        HashMap<String, Object> results = new HashMap<>();
        results.put("ELECTRIC", electricCount);
        results.put("GAS", gasCount);
        results.put("PEOPLE", peopleCount);
        results.put("ROBOTS", robotsCount);
        results.put("DINING", diningCount);
        results.put("NOT_DINING", notDiningCount);

        HashMap<String, Integer> consumption = new HashMap<>();
        consumption.put("ELECTRIC", electricConsumption);
        consumption.put("GAS", gasConsumption);
        results.put("CONSUMPTION", consumption);

        return results;
    }
}
