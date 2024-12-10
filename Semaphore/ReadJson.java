package Semaphore;

import CarStation.Car;
import Queues.Queues;
import Queues.ArrayQueue;

import java.io.File;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

public class ReadJson {
    private final String folderPath;
    private File[] files;
    private int currentIndex = 0;

    public ReadJson(String folderPath) {
        this.folderPath = folderPath;
        File folder = new File(folderPath);
        this.files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
    }

    public Queues<Car> readCarsFromJsonFiles() {
        Queues<Car> carQueue = new ArrayQueue<Car>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("Reading car from file: " + file.getName());
                    Car car = readCarFromJsonFile(file);
                    if (car != null) {
                        carQueue.enqueue(car);
                    }
                }
            }
        } else {
            System.err.println("No files found in folder: " + folderPath);
        }
        return carQueue;
    }


    public File getNextFile() {
        if (files != null && currentIndex < files.length) {
            return files[currentIndex++];
        }
        return null;
    }


    public Car readCarFromJsonFile(File file) {
        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(new java.io.FileReader(file));

            if (parsed instanceof JSONObject) {
                JSONObject carData = (JSONObject) parsed;
                return parseCarFromJson(carData);
            } else {
                System.err.println("Invalid JSON format in file: " + file.getName());
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + file.getName());
            e.printStackTrace();
        }
        return null;
    }

    private Car parseCarFromJson(JSONObject carData) {
        int id = ((Long) carData.get("id")).intValue();
        String fuelType = (String) carData.get("type");
        String dinnerType = (String) carData.get("passengers");
        boolean isDining = (boolean) carData.get("isDining");
        int consumption = ((Long) carData.get("consumption")).intValue();

        return new Car(id, fuelType, dinnerType, isDining, consumption);
    }
}
