package behavioral;

public class CommandPattern {
    public static void main(String[] args) {
        Receiver tv = new TV();
        Command tvOnCommand = new PowerOnCommand( tv );
        Command tvOffCommand = new PowerOffCommand( tv );
        Remote remote = new Remote(tvOnCommand);
        remote.invoke();

        /*
        RealWorld Usecases - Undo in Editors, Job Queues, Spring Filter chain(mix of command and CoR), CQRS
        * */
    }
}

interface Command{
    public void execute();
}

class PowerOnCommand implements Command{

    Receiver receiver;
    PowerOnCommand( Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("Powering ON the Device");
    }
}

class PowerOffCommand implements Command{
    Receiver receiver;
    PowerOffCommand( Receiver receiver){
        this.receiver = receiver;
    }
    @Override
    public void execute() {
        System.out.println("Powering OFF Below Device");
        receiver.action();
    }
}

interface Receiver{
    void action();
}

class TV implements Receiver{

    @Override
    public void action() {
        System.out.println("TV action is performed");
    }
}

interface Invoker{
    void invoke();
}
class Remote implements Invoker{
    //usually we have a Map of commandName and objject like Map<String, Command>
    private final Command command;

    Remote(Command command) {
        this.command = command;
    }

    @Override
    public void invoke() {
        command.execute();
    }
}
