package service;

import model.Elevator;
import model.ElevatorBank;
import model.ElevatorRequest;

public class SchedulerService {
    private SchedulerStrategy strategy;
    private ElevatorBank bank;

    public void schedule(ElevatorRequest request){
        Elevator choosen = strategy.handleRequest( request );
    }

}
