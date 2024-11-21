package services;

import model.Seat;
import model.repository.IDatabaseRepository;

import java.util.List;
import java.util.function.Predicate;

public class SeatService {

    private final IDatabaseRepository<Seat, Integer> seatRepo;

    public SeatService(IDatabaseRepository<Seat, Integer> seatRepo) {
        this.seatRepo = seatRepo;
    }

    public List<Seat> findAllSeats( int showId){
        Predicate<Seat> predicate = seat -> seat.getShowId() == showId;
        return seatRepo.findByCondition( predicate );

    }

    public List<Seat> findAvailableSeats( int showId){
        Predicate<Seat> predicate = seat -> seat.getShowId() == showId && seat.getHeldByUser() == null;
        return seatRepo.findByCondition( predicate );

    }

    public boolean bookSeats( List<Integer> seats ){

        return true;
    }
}
