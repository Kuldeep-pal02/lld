package behavioral;

public class StrategyPattern {
    //At runtime choose the algorithm that needs to be run, no need to change the client code.
    public static void main(String[] args) {
        MoveContext moveContext = new MoveContext( new StrategyAir() );
        moveContext.move();
        moveContext.setStrategy( new StrategyWater());
        moveContext.move();
        moveContext.setStrategy( new StrategyLand());
        moveContext.move();
    }
    //Let's say this MoveContext is created using some config, then the creation logic based on the config,
    //will provide the correct logic at the time of starting the appliction. We dont need to change the code where
    // MoveContext class is being used. We can provide apis to change the strategy by using setStrategy method on the runtime.
}


interface Strategy {
    public void action();
}
class StrategyAir implements Strategy{

    @Override
    public void action() {
        System.out.println( "I am flying");
    }
}
class StrategyWater implements Strategy{

    @Override
    public void action() {
        System.out.println( "I am Swimming");
    }
}
class StrategyLand implements Strategy{

    @Override
    public void action() {
        System.out.println( "I am Running");
    }
}

class MoveContext{
    Strategy strategy;
    MoveContext( Strategy strategy ){
        this.strategy = strategy;
    }
    public void move(){
        this.strategy.action();
    }
    public void setStrategy( Strategy strategy ){
        this.strategy = strategy;
    }
}
