package game;

public abstract class Shape {

    public static Integer posX;
    public static Integer posY;

    Shape(Integer posX, Integer posY) {
        Shape.posX = posX;
        Shape.posY = posY;
    }
}