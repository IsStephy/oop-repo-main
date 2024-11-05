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
}

public class CoffeeShop {
    public static void main(String[] args) {

    }
}
