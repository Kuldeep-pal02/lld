package services;

import model.Booking;
import model.Seat;
import model.repository.IDatabaseRepository;

import java.util.List;

public class BookingService {
    private final IDatabaseRepository<Booking, Integer> bookingRepo;
    private final IDatabaseRepository<Seat, Integer> seatRepo;

    public BookingService(IDatabaseRepository<Booking, Integer> bookingRepo, IDatabaseRepository<Seat, Integer> seatRepo) {
        this.bookingRepo = bookingRepo;
        this.seatRepo = seatRepo;
    }

    public boolean bookSeats(List<Seat> seatList , int userId){
        return false;
    }
}
