package creational;


public class FactoryMethod {
    /* This pattern gives an interface for creating objects in superclass, every sub class implements its
    based on its own creation login

    -- Good practice avoid directly calling the new to instantiate a class ( or in addition to new method provide a
    factory method to allow your clients to create/get new instances), instead use a factory to get the new object,
    why ? Because now you can change the logic of creation without breaking the clients.


    What about having a static method that creates and return the instance,
    The main disadvantage of providing only static factory methods is that classes
    without public or protected constructors cannot be subclassed. Very important.

    So we have 2 types of factory methos, inheritance based, and static method based.
    * */


    //type - static method based
    public static FactoryMethod getFactoryMethodInstance(){
        return new FactoryMethod();
    }
    private FactoryMethod(){

    }

    //Type - Inheritance level
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new EmailNotificationFactory() ;
        NotificationFM nt = notificationFactory.getInstance();
        nt.send("Eagle has landed");
    }
}


interface NotificationFM{
    void send(String message);
}

class EmailNotification implements NotificationFM {

    String type;
    @Override
    public void send(String message) {
        System.out.println("Sending Email");
    }

    //these changes are to facilicate Builder changes - start
    EmailNotification( NotificationBuilder builder){
        this.type = builder.type;
    }

    EmailNotification( ){
    }
}

class SMSNotification implements NotificationFM {

    @Override
    public void send(String message) {
        System.out.println( "Sending SMS");
    }
}

interface NotificationFactory{
    NotificationFM getInstance();
}
class EmailNotificationFactory implements  NotificationFactory{

    @Override
    public NotificationFM getInstance() {
        return new EmailNotification();
    }
}

class SMSNotificationFactory implements  NotificationFactory{

    @Override
    public NotificationFM getInstance() {
        return new SMSNotification();
    }
}

