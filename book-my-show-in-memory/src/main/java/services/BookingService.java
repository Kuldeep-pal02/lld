package services;

import dto.BookingRequestDto;
import model.Booking;
import model.Seat;
import model.repository.IDatabaseRepository;
import services.payments.BMSPayments;

import java.util.List;

import static model.BookingStatus.*;

public class BookingService {
    private final IDatabaseRepository<Booking, Long> bookingRepo;

    private final SeatService seatService ;
    private final BMSPayments bmsPayments;

    public BookingService( IDatabaseRepository<Booking,Long> bookingRepo, SeatService seatService, BMSPayments bmsPayments ) {
        this.bookingRepo = bookingRepo;
        this.seatService = seatService;
        this.bmsPayments = bmsPayments;
    }

    public boolean initiateBooking( BookingRequestDto bookingRequestDto ){
        Booking newBooking = BookingRequestDto.getBookingFromDto( bookingRequestDto );
        bookingRepo.save( newBooking );
        return true;
    }

    public boolean holdSeatsForBooking( BookingRequestDto bookingRequestDto ){
        List<Seat> seatList = bookingRequestDto.getSeatList();
        seatService.holdSeats( seatList, bookingRequestDto.getUserId() );
        return true;
    }
    public boolean makePaymentForBooking( BookingRequestDto bookingRequestDto ){
        bmsPayments.collectPayment( bookingRequestDto );
        return true;
    }

    public synchronized boolean  confirmBooking( long  bookingId ){
        Booking booking = bookingRepo.findById( bookingId );
        if( ! IN_PROGRESS.equals( booking.getBookingStatus() ) ){
            throw new RuntimeException( "Booking status is not updatable :: its already "+ booking.getBookingStatus() );
        }
        booking.setBookingStatus(  COMPLETED );
        bookingRepo.save( booking );
        return true;
    }

    public boolean cancelBooking( long  bookingId ){
        Booking booking = bookingRepo.findById( bookingId );
        if( ! COMPLETED.equals( booking.getBookingStatus() ) ){
            throw new RuntimeException( "Booking status is not Cancellable :: its "+ booking.getBookingStatus() );
        }
        booking.setBookingStatus(  CANCELLED );

        seatService.releaseSeats( booking.getSeatList() );
        bookingRepo.save( booking );

        return true;
    }
}
