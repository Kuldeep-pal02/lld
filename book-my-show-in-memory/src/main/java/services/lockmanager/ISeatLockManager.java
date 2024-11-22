package services.lockmanager;

import java.util.List;

public interface ISeatLockManager {
    boolean lockSeat( int seatId, int userId );

    void unlockSeat( int seatId, int userId );

    boolean lockBulkSeats( List<Integer> seatIds, int userId );

    void revertLockBulkSeats( List<Integer> seatIds, int userId );
}
