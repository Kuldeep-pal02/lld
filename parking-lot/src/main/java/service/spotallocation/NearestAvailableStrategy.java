package service.spotallocation;

import model.Floor;
import model.IVehicle;
import model.ParkingSpot;
import model.SpotStatus;

import java.util.List;

import static model.SpotStatus.ALLOCATED;
import static model.SpotStatus.FREE;

public class NearestAvailableStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot allocate(List<Floor> floors, IVehicle vehicle) {
        for( Floor floor : floors ){
            for( ParkingSpot spot : floor.parkingSpotList ){
                if( spot.status == SpotStatus.FREE && vehicle.getTypes().contains(  spot.type ) ){
                    spot.status = ALLOCATED;
                    spot.parkedVehicle = vehicle;
                    return spot;
                }
            }
        }
        return null;
    }

    @Override
    public void releaseSpot(ParkingSpot spot) {
        spot.status = FREE;
        spot.parkedVehicle = null;
    }


}
