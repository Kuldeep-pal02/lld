package dto;

import lombok.Data;
import model.Booking;
import model.Seat;

import java.util.List;

import static model.BookingStatus.IN_PROGRESS;

@Data
public class BookingRequestDto {
    private int userId;
    private int booking;
    private int showId;
    private List<Seat> seatList;
    private int bookingId;
    private int amount;

    public static Booking getBookingFromDto( BookingRequestDto dto ){
        Booking newBooking = new Booking();
        newBooking.setBookingStatus( IN_PROGRESS  );
        newBooking.setSeatList( dto.getSeatList() );
        newBooking.setShowId( dto.getShowId() );
        newBooking.setUserId( dto.getUserId() );
        newBooking.setId( System.currentTimeMillis() );
        return newBooking;
    }
}
