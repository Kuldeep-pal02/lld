package model;

import lombok.Data;

@Data
public class Seat {
    int id;
    int showId;
    SeatType seatType;
    User heldByUser;
    long holdExpiryTime;
    User bookedByUser;

}
