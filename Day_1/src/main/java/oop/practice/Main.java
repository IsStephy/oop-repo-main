package oop.practice;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);

        System.out.print("Is this being human? (true/false): ");
        boolean isHuman = scanner.nextBoolean();

        System.out.println("Select a planet (0: EARTH, 1: ASGARD, 2: BETELGEUSE, 3: VOGSPHERE, 4: KASHYYYK, 5: ENDOR): ");
        int planetChoice = scanner.nextInt();
        Planet planet = Planet.values()[planetChoice];

        System.out.print("Enter the age: ");
        int age = scanner.nextInt();

        System.out.println("\n--- Character Summary ---");
        System.out.println("Is Human: " + isHuman);
        System.out.println("Planet: " + planet);
        System.out.println("Age: " + age);

        scanner.close();
    }
}

record Universe(
        String name,
        List<JsonNode> individuals
){}
