package service;

import model.Floor;
import model.IVehicle;
import model.ParkingSpot;
import model.SpotStatus;
import service.spotallocation.SpotAllocationStrategy;

import java.util.List;

public class SpotAllocatorService implements  ISpotAllocator{


    private final  List<Floor> floors;
    private final SpotAllocationStrategy strategy;

    public SpotAllocatorService(List<Floor> floors, SpotAllocationStrategy strategy) {
        this.floors = floors;
        this.strategy = strategy;
    }

    @Override
    public ParkingSpot findSpot(IVehicle iVehicle) {
        return strategy.allocate(floors, iVehicle);
    }

    @Override
    public void freeTheSpot(ParkingSpot parkingSpot) {
        strategy.releaseSpot( parkingSpot );
    }
}
