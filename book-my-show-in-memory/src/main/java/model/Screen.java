package model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Screen {

    int id;
    int totalNumberOfSeats;
    List<Seat> seatList;

    Map<SeatType , List<Seat>> seatTypeListMap;
}
