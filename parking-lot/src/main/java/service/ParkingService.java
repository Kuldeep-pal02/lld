package service;

import model.ITicket;
import model.IVehicle;
import model.ParkingSpot;
import service.billing.BillingService;
import service.billing.PricingStrategy;

import java.util.Random;

public class ParkingService {
    //this class will only orchestrate,
    private final ITicketManager ticketManager;
    private final ISpotAllocator spotAllocator;
    private final BillingService billingService;
    private final IPaymentCollectorService collectorService;

    public ParkingService(ITicketManager ticketManager, ISpotAllocator spotAllocator, BillingService billingService, IPaymentCollectorService collectorService) {
        this.ticketManager = ticketManager;
        this.spotAllocator = spotAllocator;
        this.billingService = billingService;
        this.collectorService = collectorService;
    }

    public ITicket park (IVehicle vehicle){
        ParkingSpot spot = spotAllocator.findSpot( vehicle );
        ITicket ticket = ticketManager.createTicket( vehicle, spot );
        return ticket;
    }

    public boolean unPark(ITicket tkt){
        ParkingSpot spot = tkt.getSpot();
        spotAllocator.freeTheSpot(spot );
        collectorService.collectPayment( new PaymentRequest( tkt.getId() , billingService.calculate( tkt ), new Random(50l).nextInt()) );
        return true;
    }

}
