package services;

import model.User;
import model.repository.IDatabaseRepository;

public class UserService {

    private final IDatabaseRepository<User, Integer> userRepo;

    public UserService( IDatabaseRepository<User,Integer> userRepo ) {
        this.userRepo = userRepo;
    }

    public User getUserById( int id ){
        return userRepo.findById( id );
    }
}
