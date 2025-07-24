package service.billing;

import model.ITicket;

public class SurgePricingDecorator extends PricingDecorator{

    private final int surgeMultiplier;

    public SurgePricingDecorator(PricingStrategy wrapped, int surgeMultiplier) {
        super(wrapped);
        this.surgeMultiplier = surgeMultiplier;
    }


    @Override
    public int calculateCharge(ITicket ticket) {
        int basePrice = pricingStrategy.calculateCharge(ticket);
        return basePrice * surgeMultiplier;
    }
}
