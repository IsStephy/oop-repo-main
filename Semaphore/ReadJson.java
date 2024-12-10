package Semaphore;

import CarStation.Car;
import Queues.ArrayQueue;
import Queues.Queues;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class ReadJson {
    private final String folderPath;

    public ReadJson(String folderPath) {
        this.folderPath = folderPath;
    }

    public Queues<Car> readCarsFromJsonFiles() {
        Queues<Car> carQueue = new ArrayQueue<Car>();
        JSONParser parser = new JSONParser();

        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(folderPath), "*.json");
            for (Path path : stream) {
                try (FileReader reader = new FileReader(path.toFile())) {
                    JSONObject carJson = (JSONObject) parser.parse(reader);

                    int id = ((Long) carJson.get("id")).intValue();
                    String type = (String) carJson.get("type");
                    String passengers = (String) carJson.get("passengers");
                    boolean isDining = (Boolean) carJson.get("isDining");
                    int consumption = ((Long) carJson.get("consumption")).intValue();

                    Car car = new Car(id, type, passengers, isDining, consumption);
                    carQueue.enqueue(car);

                } catch (IOException | ParseException e) {
                    System.err.println("Error processing file " + path.getFileName() + ": " + e.getMessage());
                }
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.err.println("Error reading folder: " + e.getMessage());
        }

        return carQueue;
    }
}
