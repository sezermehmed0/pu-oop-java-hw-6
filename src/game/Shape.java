package game;


public abstract class Shape {

    public static int positionX;
    public static int positionY;

    Shape(int positionX, int positionY) {
        Shape.positionX = positionX;
        Shape.positionY = positionY;
    }
}