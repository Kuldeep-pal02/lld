package service.billing;

import model.ITicket;

public class BillingService {

    //What if we want to have this pricing strategy dynamically based on weekends and other thing.
    // Just have a factory of Pricing Stragety and every time you want to calculte get the object from factory.
    //Factory can return the singleton or new object based on the requirement. //Use flyhweight pattern.
    private final PricingStrategy pricingStrategy;

    public BillingService(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public int calculate(ITicket ticket){
        return this.pricingStrategy.calculateCharge( ticket );

    }
}
