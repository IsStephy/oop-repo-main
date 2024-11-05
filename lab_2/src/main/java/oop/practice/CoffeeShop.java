package oop.practice;

enum Intensity {
    LIGHT, NORMAL, STRONG
}

enum SyrupType {
    MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN
}

class Coffee {
    protected Intensity coffeeIntensity;
    protected final String name = "Coffee";

    public Coffee(Intensity coffeeIntensity) {
        this.coffeeIntensity = coffeeIntensity;
    }

    public Intensity getCoffeeIntensity() {
        return coffeeIntensity;
    }

    public String getName() {
        return name;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffee Type: " + name + ", Intensity: " + coffeeIntensity);
    }
}

class Cappuccino extends Coffee {
    private int mlOfMilk;
    protected final String coffee = "Cappuccino";

    public Cappuccino(Intensity coffeeIntensity, int mlOfMilk) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public String getCoffee() {
        return coffee;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Coffee Type: " + coffee + ", Intensity: " + coffeeIntensity + ", Milk: " + mlOfMilk + "ml");
    }

    public final Cappuccino makeCappuccino() {
        System.out.println("Making " + coffee + ":");
        System.out.println("1. Brew espresso.");
        System.out.println("2. Steam milk.");
        System.out.println("3. Combine espresso with steamed milk.");
        return this; // Return the current instance
    }
}

class Americano extends Coffee {
    private int mlOfWater;
    protected final String coffeeName = "Americano";

    public Americano(Intensity coffeeIntensity, int mlOfWater) {
        super(coffeeIntensity);
        this.mlOfWater = mlOfWater;
    }

    public int getMlOfWater() {
        return mlOfWater;
    }

    public String getCoffeeName() {
        return coffeeName;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Coffee Type: " + coffeeName + ", Intensity: " + coffeeIntensity + ", Water: " + mlOfWater + "ml");
    }

    public final Americano makeAmericano() {
        System.out.println("Making " + coffeeName + ":");
        System.out.println("1. Brew espresso.");
        System.out.println("2. Add " + mlOfWater + "ml of hot water.");
        return this; // Return the current instance
    }
}

class SyrupCappuccino extends Cappuccino {
    private SyrupType syrup;
    protected final String coffee = "SyrupCappuccino";

    public SyrupCappuccino(Intensity coffeeIntensity, int mlOfMilk, SyrupType syrup) {
        super(coffeeIntensity, mlOfMilk);
        this.syrup = syrup;
    }

    public SyrupType getSyrup() {
        return syrup;
    }

    @Override
    public String getCoffee() {
        return coffee;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Coffee Type: " + coffee + ", Intensity: " + coffeeIntensity + ", Milk: " + getMlOfMilk() + "ml, Syrup: " + syrup);
    }

    public final SyrupCappuccino makeSyrupCappuccino() {
        System.out.println("Making " + coffee + ":");
        System.out.println("1. Brew espresso.");
        System.out.println("2. Steam milk.");
        System.out.println("3. Combine espresso with steamed milk and add syrup: " + syrup);
        return this; // Return the current instance
    }
}

class PumpkinSpiceLatte extends Coffee {
    private int mlOfMilk;
    private int mgOfPumpkinSpice;
    protected final String coffee = "PumpkinSpiceLatte";

    public PumpkinSpiceLatte(Intensity coffeeIntensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(coffeeIntensity);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }

    public int getMgOfPumpkinSpice() {
        return mgOfPumpkinSpice;
    }

    @Override
    public void printCoffeeDetails() {
        System.out.println("Coffee Type: " + coffee + ", Intensity: " + coffeeIntensity + ", Milk: " + mlOfMilk + "ml, Pumpkin Spice: " + mgOfPumpkinSpice + "mg");
    }

    public final PumpkinSpiceLatte makePumpkinSpiceLatte() {
        System.out.println("Making " + coffee + ":");
        System.out.println("1. Brew espresso.");
        System.out.println("2. Add steamed milk.");
        System.out.println("3. Add " + mgOfPumpkinSpice + "mg of pumpkin spice.");
        return this; // Return the current instance
    }
}

// Barista class handles coffee creation and encapsulates the Coffee class
class Barista {
    public void makeCoffees(Intensity intensity, String coffeeType, int mlOfMilk, int mlOfWater, SyrupType syrup, int mgOfPumpkinSpice) {
        switch (coffeeType.toLowerCase()) {
            case "cappuccino":
                Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
                cappuccino.makeCappuccino();
                cappuccino.printCoffeeDetails();
                break;
            case "americano":
                Americano americano = new Americano(intensity, mlOfWater);
                americano.makeAmericano();
                americano.printCoffeeDetails();
                break;
            case "syrupcappuccino":
                SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
                syrupCappuccino.makeSyrupCappuccino();
                syrupCappuccino.printCoffeeDetails();
                break;
            case "pumpkinspicelatte":
                PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
                pumpkinSpiceLatte.makePumpkinSpiceLatte();
                pumpkinSpiceLatte.printCoffeeDetails();
                break;
            default:
                System.out.println("Unknown coffee type: " + coffeeType);
                break;
        }
    }
}

// Main class to run the application
public class CoffeeShop {
    public static void main(String[] args) {
        Barista barista = new Barista();

        // Making different types of coffee through Barista
        barista.makeCoffees(Intensity.NORMAL, "cappuccino", 120, 0, null, 0); // Making a Cappuccino
        barista.makeCoffees(Intensity.STRONG, "americano", 0, 200, null, 0); // Making an Americano
        barista.makeCoffees(Intensity.LIGHT, "syrupcappuccino", 150, 0, SyrupType.VANILLA, 0); // Making a Syrup Cappuccino
        barista.makeCoffees(Intensity.NORMAL, "pumpkinspicelatte", 100, 0, null, 50); // Making a Pumpkin Spice Latte
    }
}
