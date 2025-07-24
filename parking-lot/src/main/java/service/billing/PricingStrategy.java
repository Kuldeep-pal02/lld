package service.billing;

import model.ITicket;

public interface PricingStrategy {
    public int calculateCharge( ITicket ticket );
}
