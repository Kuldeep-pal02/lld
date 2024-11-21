package model.repository;

import model.Show;

public class ShowRepo extends BaseRepository<Show, Integer> {
    @Override
    Integer getId(Show entity) {
        return entity.getId();
    }
}
