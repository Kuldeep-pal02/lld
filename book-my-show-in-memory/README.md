#**BookMyShow**

**Requirements**
1) View Available List of Movie and theaters.
2) View Available seats in a show.
3) Book Multiple seats in one booking, Max of 3 seats.
4) User will be able to see the booking history.
5) No two users should be able to book same seat.
6) Payment Integration



**Pattern That can be used in BMS**

Structural Patterns - 
1) Strategy/Adapter pattern for Making payment - (We choose adapter here why ?)We can have Interface IPaymentSystem and then have different paymentSystem like CC, CASH Lets say we have Already integrated with BillDesk to make payments but now  bill desk is out, how to quickly adapt to new payment System Stripe 
2) Facade Pattern for simplify access to complex system - in this case booking , payment, notification etc 
3) Proxy Patter for storing cached data for Movie etc. - 

Behavioural Pattern - 
1) Observer pattern - for notifying customers for new movies/Events
2) Strategy pattern - for deciding pricing like regular prices, surge prices, Discounted pricing 
3) Command Pattern - for Queue and execute seat booking or cancellation requests asynchronously.
      

    public interface Command {
      void execute();
      }
    }
    public class BookSeatCommand implements Command {
        private SeatService seatService;
        private Seat seat;
        public BookSeatCommand(SeatService seatService, Seat seat) {
            this.seatService = seatService;
            this.seat = seat;
        }



        @Override
        public void execute() {
            seatService.bookSeat(seat);
        }
    }

    public class CommandExecutor {
        private Queue<Command> commandQueue = new LinkedList<>();
    
        public void addCommand(Command command) {
            commandQueue.add(command);
        }
    
        public void executeCommands() {
            while (!commandQueue.isEmpty()) {
                commandQueue.poll().execute();
            }
        }
    }



Creational patterns -
1) Factory Patterns - Create objects like user, Admin, Guest based on roles through factory
2) Singlenton - Ensure we have single instance of Classes like notification service , booking service
3) Buildr Pattern - Build complex objects like Booking with multiple optional fields.


    public class Booking {
        private User user;
        private Show show;
        private List<Seat> seats;
        private double price;
        
        private Booking(Builder builder) {
            this.user = builder.user;
            this.show = builder.show;
            this.seats = builder.seats;
            this.price = builder.price;
        }
    
        public static class Builder {
            private User user;
            private Show show;
            private List<Seat> seats;
            private double price;
    
            public Builder setUser(User user) {
                this.user = user;
                return this;
            }
    
            public Builder setShow(Show show) {
                this.show = show;
                return this;
            }
    
            public Builder setSeats(List<Seat> seats) {
                this.seats = seats;
                return this;
            }
    
            public Builder setPrice(double price) {
                this.price = price;
                return this;
            }
    
            public Booking build() {
                return new Booking(this);
            }
        }
    }



Custom Patterns
1) Lock Manager - to prevent raceCondition - For distributed services we use Distributed Lock Manager

