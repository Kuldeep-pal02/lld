package structural;

public class BridgePattern {
    /*
    * Lets you split a big abstraction into 2 independent hierarchies - one for abstraction and one for the
    * implementation - and connecting them via composition.
    * Core idea is that you dont create a class for every combination, like smartTV, OldTVWithRemote, Smart4KTV etc
    * Abstraction and Implementation these words are very heavy, in simple terms, Abstraction is interface, is a high
    * level control layer for some entity which is not supposed to do real work, it is supposed to delegate the work
    * to someone( which is implementation layer also called platform.)
    * */
    public static void main(String[] args) {
        Shape redSquare = new Square( new RedColor() );
        redSquare.draw();
        Shape blueZCircle = new Circle( new BlueColor() );
        blueZCircle.draw();

    }
}

interface Color {
    void applyColor();
}

class RedColor implements Color {
    public void applyColor() {
        System.out.println("Applying Red Color");
    }
}

class BlueColor implements Color {
    public void applyColor() {
        System.out.println("Applying Blue Color");
    }
}

abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    abstract void draw();
}

class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    public void draw() {
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}

