package service.billing;

import model.ITicket;

public class DiscountDecorator extends PricingDecorator{

    private final int discountPercentage;

    public DiscountDecorator(PricingStrategy wrapped, int discountPercentage) {
        super(wrapped);
        this.discountPercentage = discountPercentage;
    }


    @Override
    public int calculateCharge(ITicket ticket) {
        int basePrice = pricingStrategy.calculateCharge(ticket);
        return basePrice - (basePrice * discountPercentage / 100);
    }
}
