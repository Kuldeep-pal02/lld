package services.lockmanager;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SingleNodeSeatLockManager implements ISeatLockManager {

    private final Map<Integer, Integer> lockedSeats = new ConcurrentHashMap<>(); // seatId -> userId

    @Override
    public synchronized boolean lockSeat( int seatId, int userId ) {
        if (lockedSeats.containsKey(seatId)) {
            if( lockedSeats.get( seatId ) == userId ){
                return true;
            }
            return false;
        }
        lockedSeats.put(seatId, userId);
        return true;
    }

    @Override
    public synchronized void unlockSeat( int seatId, int userId ) {
        if( lockedSeats.getOrDefault( seatId, 0 ) != userId){
            return;
        }
        lockedSeats.remove(seatId);
    }

    @Override
    public synchronized boolean lockBulkSeats( List<Integer> seatIds, int userId ) {
        for( Integer seatId: seatIds){
            if ( !this.lockSeat( seatId, userId )){
                revertLockBulkSeats(seatIds, userId);
                return false;
            }
        }
        return true;
    }

    @Override
    public void revertLockBulkSeats( List<Integer> seatIds, int userId ) {
        for( Integer seatId: seatIds){
            unlockSeat( seatId, userId );
        }
    }
}
