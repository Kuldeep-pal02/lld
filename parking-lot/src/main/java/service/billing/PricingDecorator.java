package service.billing;

public abstract class PricingDecorator implements PricingStrategy{
    protected final PricingStrategy pricingStrategy;

    protected PricingDecorator(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

}
