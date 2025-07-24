package service;

import model.ITicket;
import model.IVehicle;
import model.ParkingSpot;
import model.ParkingTicket;

public class TicketService implements ITicketManager{
    @Override
    public ParkingTicket createTicket(IVehicle vehicle, ParkingSpot parkingSpot) {
        ParkingTicket tkt =  new ParkingTicket();
        tkt.iVehicle = vehicle;
        tkt.parkingSpot = parkingSpot;
        tkt.inTime = System.currentTimeMillis();
        return tkt;
    }
}
