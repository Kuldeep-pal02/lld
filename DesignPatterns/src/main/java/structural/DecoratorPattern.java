package structural;

public class DecoratorPattern {
    /*
    Allows us to dynamically add new reponsibilites to objects without modifiying their code.

    * */

    public static void main(String[] args) {
        Coffee coffee = new MilkDecorator( new SugarDecorator( new Expresso() ) );
        System.out.println( coffee.getCost() );
        System.out.println( coffee.getDescription() );
    }
}

interface Coffee{
    String getDescription();
    int getCost();
}

class Expresso implements Coffee{

    @Override
    public String getDescription() {
        return "THis is Expresso coffee";
    }

    @Override
    public int getCost() {
        return 10;
    }
}

abstract class CoffeeDecorator implements Coffee{
    Coffee baseCoffee;
    CoffeeDecorator( Coffee baseCoffee ){
        this.baseCoffee = baseCoffee;
    }
}

class MilkDecorator extends CoffeeDecorator{

    MilkDecorator( Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
        return baseCoffee.getDescription() + " added with MILK";
    }

    @Override
    public int getCost() {
        return baseCoffee.getCost() + 2;
    }
}

class SugarDecorator extends CoffeeDecorator{

    SugarDecorator(Coffee coffee){
        super(coffee);
    }
    @Override
    public String getDescription() {
        return baseCoffee.getDescription() + " added with Sugar";
    }

    @Override
    public int getCost() {
        return baseCoffee.getCost() + 3;
    }
}
