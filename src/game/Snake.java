package game;

import Controllers.ButtonHandler;

import java.awt.*;

public class Snake extends Shape {

    public static int size;

    public static int snakeParts;

    public Snake(int positionX, int positionY, int size) {
        super(positionX, positionY);
        Snake.size = size;
    }

    /**
     * This method, draws snake's head and the body
     * @param g Object of graphics
     */
    public void draw(Graphics g) {
        for (int i = 0; i < snakeParts; i++) {
            //draws the snake head
            if (i == 0) {
                g.setColor(Color.BLUE);
                g.fillOval(ButtonHandler.coordinateX[i], ButtonHandler.coordinateY[i], size, size);
            }
            //draws the snake body
            else {
                g.setColor(Color.BLACK);
                g.fillRect(ButtonHandler.coordinateX[i], ButtonHandler.coordinateY[i], size, size);
            }
        }
    }
}
