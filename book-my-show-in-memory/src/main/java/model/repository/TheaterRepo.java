package model.repository;

import model.Theater;

import java.util.List;
import java.util.Map;

public class TheaterRepo extends BaseRepository<Theater, Integer> {

    @Override
    Integer getId(Theater entity) {
        return entity.getId();
    }
}
