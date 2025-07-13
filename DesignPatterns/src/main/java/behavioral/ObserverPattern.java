package behavioral;

import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    //There is one subject, if the state of subject is changed its being notified to all the subscriber
    //Publisher --> Composes --- > Subscriber and the State.

    public static void main(String[] args) {
        Publisher publisher = new LogPublisher();
        Subscriber subscriber = new ClassicLogSubscriber();
        publisher.subscribe( subscriber );
        publisher.notifyAllSubs();
        publisher.unsubscribe( subscriber );
        publisher.notifyAllSubs();


    }
}


interface Publisher{
    void subscribe(Subscriber sub);
    void unsubscribe(Subscriber sub);
    void notifyAllSubs( );
}

interface Subject{
    void update();
}

class LogPublisher implements Publisher{
    List<Subscriber> subsciberList;

    LogPublisher(){
        subsciberList = new ArrayList<>();
    }
    @Override
    public void subscribe(Subscriber sub) {
        subsciberList.add( sub );
    }

    @Override
    public void unsubscribe(Subscriber sub) {
        subsciberList.remove( sub );
    }

    public  void notifyAllSubs( ){
        for( Subscriber subscriber : subsciberList ){
            subscriber.action();
        }
    }

}

interface Subscriber{
    void action();
}
class ClassicLogSubscriber implements  Subscriber{
    public void action(){
        System.out.println( "Got the update for this "+ this);
    }
}
