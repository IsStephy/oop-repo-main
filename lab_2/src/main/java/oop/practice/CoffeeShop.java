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
        return this;
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
        return this;
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
        return this;
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
        return this;
    }
}

class Barista {
    public Cappuccino makeCappuccino(Intensity intensity, int mlOfMilk) {
        Cappuccino cappuccino = new Cappuccino(intensity, mlOfMilk);
        cappuccino.makeCappuccino();
        return cappuccino;
    }

    public PumpkinSpiceLatte makePumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(intensity, mlOfMilk, mgOfPumpkinSpice);
        pumpkinSpiceLatte.makePumpkinSpiceLatte();
        return pumpkinSpiceLatte;
    }

    public Americano makeAmericano(Intensity intensity, int mlOfWater) {
        Americano americano = new Americano(intensity, mlOfWater);
        americano.makeAmericano();
        return americano;
    }

    public SyrupCappuccino makeSyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(intensity, mlOfMilk, syrup);
        syrupCappuccino.makeSyrupCappuccino();
        return syrupCappuccino;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Barista barista = new Barista();

        Cappuccino cappuccino = barista.makeCappuccino(Intensity.NORMAL, 120); // Making a Cappuccino
        PumpkinSpiceLatte pumpkinSpiceLatte = barista.makePumpkinSpiceLatte(Intensity.NORMAL, 100, 50);
        Americano americano = barista.makeAmericano(Intensity.STRONG, 200);
        SyrupCappuccino syrupCappuccino = barista.makeSyrupCappuccino(Intensity.LIGHT, 150, SyrupType.VANILLA);

    }
}

