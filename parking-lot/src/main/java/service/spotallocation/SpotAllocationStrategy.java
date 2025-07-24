package service.spotallocation;

import model.Floor;
import model.IVehicle;
import model.ParkingSpot;

import java.util.List;

public interface SpotAllocationStrategy {
    ParkingSpot allocate(List<Floor> floors, IVehicle vehicle);
    public void releaseSpot(ParkingSpot spot);
}
