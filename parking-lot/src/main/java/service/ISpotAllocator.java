package service;

import model.IVehicle;
import model.ParkingSpot;

public interface ISpotAllocator {
    public ParkingSpot findSpot(IVehicle iVehicle);
    public void freeTheSpot( ParkingSpot parkingSpot);
}
