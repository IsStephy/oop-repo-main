package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public enum Planet {
        EARTH, ASGARD, BETELGEUSE, VOGSPHERE, KASHYYYK, ENDOR
    }

    public enum Trait {
        HAIRY, TALL, SHORT, BLONDE, EXTRA_ARMS, EXTRA_HEAD, GREEN, BULKY, POINTY_EARS
    }

    private boolean isHuman;
    private Planet planet;
    private int age;
    private List<Trait> traits;

    public Main(boolean isHuman, Planet planet, int age, List<Trait> traits) {
        this.isHuman = isHuman;
        this.planet = planet;
        this.age = age;
        this.traits = traits;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean isHuman) {
        this.isHuman = isHuman;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Trait> getTraits() {
        return traits;
    }

    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            // Read the JSON file
            JsonNode root = mapper.readTree(new File("oop-repo-main/Day_2/src/main/resources/test-input.json"));
            JsonNode data = root.get("data");

            if (data != null && data.isArray()) {
                for (JsonNode individual : data) {
                    boolean isHuman = individual.has("isHumanoid") && individual.get("isHumanoid").asBoolean();

                    Planet planet = Planet.EARTH; // Default planet
                    if (individual.has("planet")) {
                        String planetStr = individual.get("planet").asText().toUpperCase();
                        try {
                            planet = Planet.valueOf(planetStr);
                        } catch (IllegalArgumentException e) {
                            System.out.println("Unknown planet: " + planetStr + ". Defaulting to EARTH.");
                        }
                    }

                    int age = individual.has("age") ? individual.get("age").asInt() : 0; // Default age to 0 if absent

                    List<Trait> traits = new ArrayList<>();
                    if (individual.has("traits")) {
                        for (JsonNode traitNode : individual.get("traits")) {
                            try {
                                traits.add(Trait.valueOf(traitNode.asText().toUpperCase()));
                            } catch (IllegalArgumentException e) {
                                System.out.println("Unknown trait: " + traitNode.asText() + ". Skipping.");
                            }
                        }
                    }

                    // Create Main instance and print the details
                    Main character = new Main(isHuman, planet, age, traits);

                    System.out.println("\n--- Character Summary ---");
                    System.out.println("Is Human: " + character.isHuman());
                    System.out.println("Planet: " + character.getPlanet());
                    System.out.println("Age: " + character.getAge());
                    System.out.println("Traits: " + character.getTraits());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
