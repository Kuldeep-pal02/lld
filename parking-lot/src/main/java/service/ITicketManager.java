package service;

import model.ITicket;
import model.IVehicle;
import model.ParkingSpot;

public interface ITicketManager {

    ITicket createTicket(IVehicle vehicle, ParkingSpot parkingSpot);
}
