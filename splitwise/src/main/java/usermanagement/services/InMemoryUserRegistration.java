package usermanagement.services;

import lombok.Data;
import usermanagement.model.SplitwiseUser;

import java.util.Map;

@Data
public class InMemoryUserRegistration implements IUserRegistration{
    Map<String,SplitwiseUser> loggedInUsers;


    public InMemoryUserRegistration( Map<String, SplitwiseUser > loggedInUsers){
        this.loggedInUsers = loggedInUsers;
    }

    @Override
    public void registerUser(SplitwiseUser user) {
        loggedInUsers.put(user.getUserId(),  user);
    }
}
