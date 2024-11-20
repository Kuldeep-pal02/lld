package model;

import lombok.Data;

@Data
public class Seat {
    int id;
    SeatType seatType;
    User heldByUser;
    int holdExpiryTime;
    User bookedByUser;

}
