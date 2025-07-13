package behavioral;

public class ChainOfResponsibilityPattern {
    //The pattern allows pass a request object to a chain of handler.

    /*If someone asks “Why CoR over just a switch-case?” You say:

“CoR lets me build modular, testable, and extendable pipelines
 where each handler is independently swappable and responsible for a single concern.
  It respects SRP and OCP.”*/


    public static void main(String[] args) {
        Handler defaultHandler = new DefaultHandler();
        Handler loggerHandler = new LoggerHandler(defaultHandler);
        Handler handlerChainStart = new ConsoleHandler(loggerHandler);
        Request request = new ComputeRequest();
        handlerChainStart.handle( request );

    }
}
interface Request{

}

class ComputeRequest implements Request{
    int op;
    int oprand1;
    int oprand2;
}
interface Handler{
    boolean shouldHandle( Request request);
    void handle( Request request );
}

class LoggerHandler implements  Handler{
    Handler next;
    LoggerHandler( Handler next){
        this.next = next;
    }
    LoggerHandler( ){
    }

    @Override
    public boolean shouldHandle(Request request) {
        int i = (int) ( Math.random() * 100) ;
        return i%2 == 0;
    }
    @Override
    public void handle(Request request){
        if( this.shouldHandle(request) ){
            System.out.println( "Handled in the LoggerHandler");
        }else{
            if( next != null ){
                next.handle(request);
            }
        }
    }
}

class ConsoleHandler implements  Handler{
    Handler next;
    ConsoleHandler( Handler next){
        this.next = next;
    }
    ConsoleHandler(){

    }
    @Override
    public boolean shouldHandle(Request request) {
        int i = (int) ( Math.random() * 100) ;
        return i%2 == 0;
    }
    @Override
    public void handle(Request request){
        if( this.shouldHandle(request) ){
            System.out.println( "Handled in the ConsoleHandler");
        }else{
            if( next != null ){
                next.handle(request);
            }
        }
    }
}

class DefaultHandler implements  Handler{
    @Override
    public boolean shouldHandle(Request request) {
       return true;
    }
    @Override
    public void handle(Request request){
        if( this.shouldHandle(request) ){
            System.out.println( "Handled in the Default Handler");
        }
    }
}
