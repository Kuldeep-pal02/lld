package model;


import lombok.Data;

@Data
public class ElevatorRequest {
    int buildingNumber;
    int elevatorBankNumber;
    int floorNumber;
    int targetFloorNumber;
    int direction;
}
