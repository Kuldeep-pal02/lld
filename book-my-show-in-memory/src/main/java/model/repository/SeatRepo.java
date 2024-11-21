package model.repository;

import model.Seat;

public class SeatRepo extends BaseRepository<Seat, Integer>{
    @Override
    Integer getId(Seat entity) {
        return entity.getId();
    }
}
