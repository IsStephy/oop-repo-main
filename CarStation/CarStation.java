package CarStation;

import Queues.Queues;

public class CarStation {
    private final Dineable diningService;
    private final Refuelable refuelingService;
    private final Queues<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queues<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
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

            if (car.isDining()) {
                diningService.serveDinner(car.getCarId());
            }

            refuelingService.refuel(car.getCarId());
        }

        System.out.println("All cars have been served!");
    }
}
