package services;

import model.Seat;
import model.User;
import model.repository.IDatabaseRepository;
import services.lockmanager.ISeatLockManager;
import services.lockmanager.SeatLockManagerFactory;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SeatService {

    private final IDatabaseRepository<Seat, Integer> seatRepo;

    private final UserService userService;
    private final ISeatLockManager seatLockManager;
    public SeatService( IDatabaseRepository<Seat,Integer> seatRepo, UserService userService ) {
        this.seatRepo = seatRepo;
        this.userService = userService;
        this.seatLockManager = SeatLockManagerFactory.getLockManager();
    }

    public List<Seat> findAllSeats( int showId){
        Predicate<Seat> predicate = seat -> seat.getShowId() == showId;
        return seatRepo.findByCondition( predicate );

    }

    public List<Seat> findAvailableSeats( int showId){
        Predicate<Seat> predicate = seat -> seat.getShowId() == showId && seat.getHeldByUser() == null;
        return seatRepo.findByCondition( predicate );

    }

    public synchronized boolean  holdSeats( List<Seat> seats, int userId ){

        User user = userService.getUserById( userId );
        List<Integer> seatIds = seats.stream().map( seat -> seat.getId() ).collect( Collectors.toList());
        seatLockManager.lockBulkSeats( seatIds, userId );
        try{
            seats.stream().forEach( seat -> {
                seatLockManager.lockSeat( seat.getId(), userId );
                seat.setHeldByUser( user );
                seat.setHoldExpiryTime( System.currentTimeMillis() + 60000 );
            } );
            seatRepo.saveBulk(  seats );
        }catch ( Exception e ){
            seatLockManager.revertLockBulkSeats( seatIds, userId  );
        }finally {

        }


        return true;
    }

    public void releaseSeats( List<Seat> seatList ) {
        checkReleasePreCondition( seatList );
        seatList.stream().forEach( seat -> {
            seat.setHeldByUser( null );
            seat.setBookedByUser( null );
            seat.setHoldExpiryTime( 0 );
        } );

        seatRepo.saveBulk( seatList );

    }

    private void checkReleasePreCondition( List<Seat> seatList ) {

    }
}
