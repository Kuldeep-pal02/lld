package model;

import lombok.Data;

@Data
public class Elevator {
    int elevatorNumber;
    int elevatorBankNumber;
    int currFloor;
    InnerPanel innerPannel;
}
