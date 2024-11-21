package model.repository;

import model.Booking;
import model.Theater;

public class BookingRepo extends BaseRepository<Booking, Long>{
    @Override
    Long getId( Booking entity ) {
        return entity.getId();
    }
}
