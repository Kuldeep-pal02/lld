package service;

import model.Elevator;
import model.ElevatorBank;
import model.ElevatorRequest;

import java.util.List;

public class NearestElevatorStrategy implements SchedulerStrategy{
    ElevatorBank bank ;
    NearestElevatorStrategy(ElevatorBank bank){
        this.bank = bank;
    }
    @Override
    public Elevator handleRequest(ElevatorRequest request) {
        List<Elevator> elevatorList = bank.elevatorList;
        Elevator best = null;
        int minDist = Integer.MAX_VALUE;
        for (Elevator e : elevatorList) {
            int distance = Math.abs(e.getCurrFloor()- request.getTargetFloorNumber());
            if (distance < minDist) {
                minDist = distance;
                best = e;
            }
        }
        return best;
    }
}
