package service;

import model.Elevator;
import model.ElevatorRequest;

public interface SchedulerStrategy {
    public Elevator handleRequest(ElevatorRequest request );
}
