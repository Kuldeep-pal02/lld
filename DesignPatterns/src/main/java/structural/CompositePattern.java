package structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePattern {
    /*
    * Composit pattern gives structure to tree-like problems, like folders, org-charts, menus,
    * it lets you treat individual and groups of objects the same way
    * */
    public static void main(String[] args) {
        CompositeComponent compositeComponent = new CompositeComponent( new ArrayList<>() );
        compositeComponent.addComponent( new LeafComponent( "Kuldeep") );
        compositeComponent.addComponent( new LeafComponent( "Pihu") );
        compositeComponent.addComponent( new LeafComponent( "Nidhi") );
        //compositeComponent.perform();
        LeafComponent component = new LeafComponent( "Standalone");
        component.perform();
        compositeComponent.addComponent( component );
        compositeComponent.perform();


    }
}


interface Component{
    void perform();
}

class LeafComponent implements Component{

    String name;
    LeafComponent( String name){
        this.name = name;
    }
    @Override
    public void perform() {
        System.out.println("THis is leaf component performing by " + this.name);
    }
}

class CompositeComponent implements Component{

    List<Component> componentList;

    CompositeComponent( List<Component> componentList ){
        this.componentList = componentList;
    }
    @Override
    public void perform() {
        for( Component component : componentList ){
            component.perform();
        }
    }
    public void addComponent( Component component ){
        componentList.add( component );
    }
    public void removeComponent( Component component ){
        componentList.remove( component );
    }
}