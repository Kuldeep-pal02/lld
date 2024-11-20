package model.repository;

import lombok.Data;
import model.*;

import java.util.Map;

@Data
public class InMemoryMysqlDatabase {

    Map<Integer ,Theater> theaterTable;
    Map<Integer ,Booking> bookingTable;
    Map<Integer ,Movie> movieTable;
    Map<Integer ,Seat> seatTable;
    Map<Integer ,Screen> screenTable;
    Map<Integer ,Show> showTable;
    Map<Integer ,User> userTable;


}
