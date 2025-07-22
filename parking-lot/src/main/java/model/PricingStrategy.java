package model;

public interface PricingStrategy {
    public int calculateCharge( ITicket ticket );
}
