package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File inputFile = new File("oop-repo-main/oop-lab_0/src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        Universe starWars = new Universe("starWars", new ArrayList<>());
        Universe hitchhikers = new Universe("hitchHiker", new ArrayList<>());
        Universe marvel = new Universe("marvel", new ArrayList<>());
        Universe rings = new Universe("rings", new ArrayList<>());

        for (JsonNode entry : data) {
            if (starWars.belongsTo(entry)) {
                starWars.individuals().add(entry);
            } else if (hitchhikers.belongsTo(entry)) {
                hitchhikers.individuals().add(entry);
            } else if (marvel.belongsTo(entry)) {
                marvel.individuals().add(entry);
            } else if (rings.belongsTo(entry)) {
                rings.individuals().add(entry);
            } else {
                System.out.println("No matching universe for entry: " + entry.toString());
            }
        }

        View view = new View();
        view.view(starWars.individuals(),hitchhikers.individuals(),rings.individuals(),marvel.individuals());
    }
}

record Universe(
        String name,
        List<JsonNode> individuals
) {
    public boolean belongsTo(JsonNode individual) {
        String planet = individual.has("planet") ? individual.get("planet").asText() : "";
        int age = individual.has("age") ? individual.get("age").asInt() : -1;
        int isHumanoid = individual.has("isHumanoid") ? (individual.get("isHumanoid").asBoolean() ? 1 : 0) : -1;
        List<String> traits = new ArrayList<>();
        if (individual.has("traits")) {
            individual.get("traits").forEach(trait -> traits.add(trait.asText()));
        }

        switch (name) {
            case "starWars":
                return isStarWars(planet, age, isHumanoid, traits);
            case "marvel":
                return isMarvel(planet, age, isHumanoid, traits);
            case "hitchHiker":
                return isHitchhikers(planet, age, isHumanoid, traits);
            case "rings":
                return isLordOfTheRings(planet, age, isHumanoid, traits);
            default:
                return false;
        }
    }

    private boolean isStarWars(String planet, int age, int isHumanoid, List<String> traits) {
        if (planet.equals("Kashyyyk") || planet.equals("Endor")) {
            return true;
        }
        if (planet.equals("")){
            if ((isHumanoid == 2 && (traits.contains("HAIRY") || traits.contains("TALL"))) && (age >= 0 && age <= 400)) {
                return true;
            }
            if ((isHumanoid == 0 && (traits.contains("HAIRY") || traits.contains("TALL"))) && (age >= 0 && age <= 400)) {
                return true;
            }
            if (isHumanoid == 0 && (traits.contains("HAIRY") || traits.contains("TALL"))) {
                return true;
            }
            if (isHumanoid == 0 && age > 200 && age < 400) {
                return true;
            }

            if ((isHumanoid == 2 && (traits.contains("HAIRY") || traits.contains("TALL"))) && (age >= 0 && age <= 60)) {
                return true;
            }
            if ((isHumanoid == 0 && (traits.contains("HAIRY") || traits.contains("TALL"))) && (age >= 0 && age <= 60)) {
                return true;
            }
            if (isHumanoid == 0 && (traits.contains("SHORT") || traits.contains("HAIRY"))) {
                return true;
            }
            if (isHumanoid == 0 && age >= 0 && age <= 60) {
                return true;
            }
        }
        return false;
    }

    private boolean isMarvel(String planet, int age, int isHumanoid, List<String> traits) {
        if (planet.equals("Asgard")) {
            return true;
        }
        if(planet.equals("")) {
            if ((isHumanoid == 2 && (traits.contains("BLONDE") || traits.contains("TALL"))) && (age >= 0 && age <= 5000)) {
                return true;
            }
            if ((isHumanoid == 1 && (traits.contains("BLONDE") || traits.contains("TALL"))) && (age >= 0 && age <= 5000)) {
                return true;
            }
            if (isHumanoid == 1 && (traits.contains("BLONDE") || traits.contains("TALL"))) {
                return true;
            }
            if (isHumanoid == 1 && age > 200 && age <= 5000) {
                return true;
            }
        }
        return false;
    }

    private boolean isHitchhikers(String planet, int age, int isHumanoid, List<String> traits) {
        if (planet.equals("Betelgeuse") || planet.equals("Vogsphere")) {
            return true;
        }
        if (planet.equals("")) {
            if ((isHumanoid == 2 && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) && (age >= 0 && age <= 100)) {
                return true;
            }
            if (isHumanoid == 1 && (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD"))) {
                return true;
            }
            if (traits.contains("EXTRA_ARMS") || traits.contains("EXTRA_HEAD")) {
                return true;
            }

            if (traits.contains("GREEN")) {
                return true;
            }
            if ((isHumanoid == 0 && (traits.contains("HAIRY") || traits.contains("TALL"))) && (age >= 0 && age <= 200)) {
                return true;
            }
            if ((isHumanoid == 2 && (traits.contains("GREEN") || traits.contains("BULKY"))) && (age >= 0 && age <= 200)) {
                return true;
            }
            if (isHumanoid == 0 && (traits.contains("GREEN") || traits.contains("BULKY"))) {
                return true;
            }
            if (isHumanoid == 0 && age >= 0 && age <= 60) {
                return true;
            }
        }
        return false;
    }

    private boolean isLordOfTheRings(String planet, int age, int isHumanoid, List<String> traits) {
        if (planet.equals("Earth")) {
            return true;
        }
        if (planet.equals("")) {
            if (age > 5000) {
                return true;
            }
            if ((isHumanoid == 2 && (traits.contains("BLONDE") || traits.contains("POINTY_EARS"))) && (age >= 0 && age <= 100)) {
                return true;
            }
            if ((isHumanoid == 1 && (traits.contains("BLONDE") || traits.contains("POINTY_EARS"))) && (age >= 0 && age <= 100)) {
                return true;
            }
            if (isHumanoid == 1 && (traits.contains("BLONDE") || traits.contains("POINTY_EARS"))) {
                return true;
            }

            if ((isHumanoid == 1 && (traits.contains("SHORT") || traits.contains("BULKY"))) && (age >= 0 && age <= 200)) {
                return true;
            }
            if ((isHumanoid == 2 && (traits.contains("SHORT") || traits.contains("BULKY"))) && (age >= 0 && age <= 200)) {
                return true;
            }
            if (isHumanoid == 1 && (traits.contains("SHORT") || traits.contains("BULKY"))) {
                return true;
            }
            if (isHumanoid == 1 && age >= 0 && age <= 60) {
                return true;
            }
        }
        return false;
    }
}