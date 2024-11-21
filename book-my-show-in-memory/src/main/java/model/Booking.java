package model;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    long id;
    int userId;
    int showId;
    List<Seat> seatList;
    BookingStatus bookingStatus;
}
