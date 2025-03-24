package creational;

public class Singleton {

    //Eager Loading
    //public volatile static Singleton INSTANCE = new Singleton();

    public volatile static Singleton INSTANCE;
    private Singleton(){

    }
    //Not ThreadSafe
    public static  Singleton getInstance(){
        if( INSTANCE == null ){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    //ThreadSafe but slow
    public  static synchronized Singleton getInstanceThreadSafe(){
        if( INSTANCE == null ){
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
    //ThreadSafe and fast, Lazy Loading but still can be broken using Reflection
    public  static Singleton getInstanceThreadSafeFast(){
        if( INSTANCE == null ){
            synchronized (Singleton.class){
                if( INSTANCE == null ){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    /** Order to overcome the situation with reflection Joshua Block suggests the use of enum to implement The singleton pattern.
     * Since Java Enum values are globally accessible, so is the singleton.
     * The drawback is that the enum type is somewhat inflexible (for example, it does not allow lazy initialization).
     *
     *
     */
    //URL -- https://www.digitalocean.com/community/tutorials/java-singleton-design-pattern-best-practices-examples#7-enum-singleton




    //BillPugh Singleton Implementation using inner static class
    /*
        Notice the private inner static class that contains the instance of the singleton class. When the singleton class is loaded,
        SingletonHelper class is not loaded into memory and only when someone calls the getInstance() method,
        this class gets loaded and creates the singleton class instance.
        This is the most widely used approach for the singleton class as it doesn’t require synchronization.
    */
    private static class SingletonHelper{
        private static final Singleton INSTANCE = new Singleton();
    }
    public static Singleton getInstanceBillPugh(){
        return SingletonHelper.INSTANCE;
    }



    /*
        Serialization and Singleton, SOmetime in distributed systems we need to implement Serializable interface in the singleton class so that
        we can store its state in the file system and retrieve it at  a later point in time.

    */




}
