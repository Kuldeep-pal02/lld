package services.lockmanager;

public class SeatLockManagerFactory {
    private final static String LOCAL_STR = "LOCAL";
    public static ISeatLockManager getLockManager(){
        String profile = LOCAL_STR;
        switch ( profile ){
            case LOCAL_STR :
                //
            default:
                return new SingleNodeSeatLockManager();
        }
    }
}
