package services.lockmanager;

import java.util.List;

public class RedisLockManager implements ISeatLockManager{
    @Override
    public boolean lockSeat( int seatId, int userId ) {
        return false;
    }

    @Override
    public void unlockSeat( int seatId, int userId ) {

    }

    @Override
    public boolean lockBulkSeats( List<Integer> seatIds, int userId ) {
        return false;
    }

    @Override
    public void revertLockBulkSeats( List<Integer> seatIds, int userId ) {

    }
}
