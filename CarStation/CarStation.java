package CarStation;

import Queues.Queues;

public class CarStation {
    private final Dineable diningService;
    private final Refuelable electricRefuelingService;
    private final Refuelable gasRefuelingService;
    private final Queues<Car> queue;

    public CarStation(Dineable diningService, Refuelable electricRefuelingService, Refuelable gasRefuelingService, Queues<Car> queue) {
        this.diningService = diningService;
        this.electricRefuelingService = electricRefuelingService;
        this.gasRefuelingService = gasRefuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
        System.out.println("Car added to the queue: " + car.getCarId());
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println("Serving car: " + car.getCarId());

            // Serve dinner if required
            if (car.isDining()) {
                diningService.serveDinner(car.getCarId());
            }

            if (car.getFuelType().equals("ELECTRIC")) {
                electricRefuelingService.refuel(car.getCarId());
            } else if (car.getFuelType().equals("GAS")) {
                gasRefuelingService.refuel(car.getCarId());
            }
        }

        System.out.println("All cars have been served!");
    }
}
