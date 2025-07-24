package service.billing;

import model.ITicket;

import java.time.temporal.ChronoUnit;

public class HourlyPricingStrategy implements PricingStrategy {

    @Override
    public int calculateCharge(ITicket ticket) {
        long hours = ( (System.currentTimeMillis() - ticket.getInTime()) /1000 )/ (60 *60);
        return (int) Math.max(1, hours) * 50;
    }
}
