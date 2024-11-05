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

    public String getCoffee() {
        return coffee;
    }
}

public class CoffeeShop {
    public static void main(String[] args) {
        Cappuccino cappuccino = new Cappuccino(Intensity.NORMAL, 150);
        Americano americano = new Americano(Intensity.STRONG, 200);
        SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.LIGHT, 150, SyrupType.VANILLA);
        PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 100, 50);

        System.out.println("Coffee: " + cappuccino.getCoffee() + ", Intensity: " + cappuccino.getCoffeeIntensity() + ", Milk: " + cappuccino.getMlOfMilk() + "ml");
        System.out.println("Coffee: " + americano.getCoffeeName() + ", Intensity: " + americano.getCoffeeIntensity() + ", Water: " + americano.getMlOfWater() + "ml");
        System.out.println("Coffee: " + syrupCappuccino.getCoffee() + ", Intensity: " + syrupCappuccino.getCoffeeIntensity() + ", Milk: " + syrupCappuccino.getMlOfMilk() + "ml, Syrup: " + syrupCappuccino.getSyrup());
        System.out.println("Coffee: " + pumpkinSpiceLatte.getCoffee() + ", Intensity: " + pumpkinSpiceLatte.getCoffeeIntensity() + ", Milk: " + pumpkinSpiceLatte.getMlOfMilk() + "ml, Pumpkin Spice: " + pumpkinSpiceLatte.getMgOfPumpkinSpice() + "mg");
    }
}
