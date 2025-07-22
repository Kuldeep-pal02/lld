package model;

import java.util.List;

public class ParkingLot {

    //Make it singleton in the application why ?
    //Why is this a class not interface ? Ans started with concrete class sunce its the orchestrator and currently have one
    // one implementaion, if we want to support lot of types like mall, airport, stadim the we can have IParkingLot like below.

    /*
    * public interface ParkingLot {
        Ticket park(Vehicle vehicle);
        boolean unpark(Ticket ticket);
        boolean isFull();
        void addFloor(Floor floor);
        void setPricingStrategy(PricingStrategy strategy);
        void printStatus();
    }
*/



    // Intially floors are acutally list for simplisity but can be discussed if we want to show the layout of
    // give floors a number and if admin wants to close a perticular floor for some time, such usecases we can this.
    List<Floor> folorList;
    List<Gate> gates;
    String name;

}
