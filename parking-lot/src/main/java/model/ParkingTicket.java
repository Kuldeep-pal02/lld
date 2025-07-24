package model;

public class ParkingTicket implements ITicket {
    int id;
    public IVehicle iVehicle;
    public ParkingSpot parkingSpot;
    public long inTime;

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public ParkingSpot getSpot() {
        return this.parkingSpot;
    }

    @Override
    public long getInTime() {
        return this.inTime;
    }
}
