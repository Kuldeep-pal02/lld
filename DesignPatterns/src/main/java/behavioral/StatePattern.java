package behavioral;

public class StatePattern {
    /*
    * Lets an object change it behaviour based on the internal state change, it appears the object has changed its
    * class. Basically take out the state that changes and put it in another class and have this class in your context.
    *
    * Context ===> Interface State{} <== ConcreteStateClasses.
    * */
    public static void main(String[] args) {
        MediaPlayer player = new MediaPlayer( new StopState() );
        player.play();
        player.forward();
        player.stop();
    }
}

interface State{
    void play();
    void stop();
    void forward();
}
class PlayingState implements State{

    @Override
    public void play() {
        System.out.println("Error : Already Playing");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Playing");
    }

    @Override
    public void forward() {
        System.out.println("Forwarded 20Secs");
    }
}

class StopState implements State{

    @Override
    public void play() {
        System.out.println("ITs not Playing");
    }

    @Override
    public void stop() {
        System.out.println("Error - Already stopped");
    }

    @Override
    public void forward() {
        System.out.println("Error - cannot stop");
    }
}
class MediaPlayer{
    State state;
    MediaPlayer(State state){
        this.state = state;
    }
    public void setState( State state ){
        this.state =  state;
    }
    public void play(){
        this.state.play();
    }
    public void stop(){
        this.state.stop();
    }
    public void forward(){
        this.state.forward();
    }
}




