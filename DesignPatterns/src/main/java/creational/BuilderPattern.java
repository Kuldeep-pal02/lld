package creational;

public class BuilderPattern {
    /*
    * lets you create complex objects step by step,
    * The builder pattern suggested to extract the object creation code out of its own class and move
    * it to separate objects called builders.
    * */


    /*
    * there are 3 ways to have builder class
    * 1) inner static class builder- standard approach, efficient
    * 2) separate class builder - more modular,resuable, prefered for using across multiple domains,effiecnt
    * 3) inner instance class builder - never used*/

    public static void main(String[] args) {
        NotificationFM notificationFM = new NotificationBuilder().type("Email").build();
        notificationFM.send("Sending through builder");
    }

}

class NotificationBuilder{
    //fields same as NotificationFM;
    String type;

    NotificationBuilder(){

    }

    public NotificationBuilder type( String type){
        this.type = type;
        return this;
    }

    public NotificationFM build(){
        NotificationFM notificationFM = new EmailNotification(  this);
        return  notificationFM;
    }


}
