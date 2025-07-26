import service.ATMContext;
import service.ATMRequest;
import service.atmstate.IdleState;

public class Application {
    public static void main(String[] args) {
        ATMContext context = new ATMContext( new IdleState() );

        //context.verifyPin( new ATMRequest() );
        context.insertCard( new ATMRequest() );
        context.verifyPin( new ATMRequest() );
    }
}
