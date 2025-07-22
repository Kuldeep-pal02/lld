package service;

import model.ITicket;
import model.IVehicle;
import model.ParkingSpot;
import model.PricingStrategy;

import java.util.Random;

public class ParkingService {
    ITicketManager ticketManager;
    ISpotAllocator spotAllocator;
    PricingStrategy pricingStrategy;
    IPaymentCollectorService collectorService;

    public ITicket park (IVehicle vehicle){
        ParkingSpot spot = spotAllocator.findSpot( vehicle );
        ITicket ticket = ticketManager.createTicket( vehicle, spot );
        return ticket;
    }

    public boolean unPark (ITicket tkt){
        ParkingSpot spot = tkt.getSpot();
        spot.freeTheSpot();
        collectorService.collectPayment( new PaymentRequest( tkt.getId() ,pricingStrategy.calculateCharge( tkt ), new Random(50l).nextInt()) );
        return true;
    }

}
