package model.repository;

import model.User;

public class UserRepo extends BaseRepository<User, Integer>{
    @Override
    Integer getId( User entity ) {
        return entity.getId();
    }
}
