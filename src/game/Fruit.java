package game;

import java.awt.*;

public class Fruit extends Shape {

    public static int size;

    public Fruit(int positionX, int positionY, int size) {
        super(positionX, positionY);
        Fruit.size = size;
    }

    /**
     * This method , draws the fruit
     * @param g Object of graphics
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(positionX, positionY, size, size);
    }
