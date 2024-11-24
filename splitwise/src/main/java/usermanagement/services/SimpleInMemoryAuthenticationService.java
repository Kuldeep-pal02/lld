package usermanagement.services;

import usermanagement.model.SplitwiseUser;

public class SimpleInMemoryAuthenticationService  implements  IAuthenticateService{
    private final InMemoryUserRegistration inMemoryUserRegistration;

    public SimpleInMemoryAuthenticationService(InMemoryUserRegistration inMemoryUserRegistration) {
        this.inMemoryUserRegistration = inMemoryUserRegistration;
    }

    @Override
    public void authenticate( SplitwiseUser user) {
        if( inMemoryUserRegistration.getLoggedInUsers().containsKey( user.getUserId() ) ){
            System.out.println( "User loggedIn : " + user.getName() );
            return;
        }
        throw new RuntimeException( " user not loggedIn ");

    }
}
