package Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class keyController implements KeyListener {

    public static int fruitsEaten;
    public static int scorePoints;

    public static boolean moveLeft = false;
    public static boolean moveRight = true;
    public static boolean moveUp = false;
    public static boolean moveDown = false;

    /**
     * This method, should move snake by calling keyListener, but it didn't works for some reason
     * @param e keyEvent Object
     */
    @Override
    public void keyPressed(KeyEvent e) {
        //move snake up
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W && (!moveDown)) {
            moveUp = true;
            moveRight = false;
            moveLeft = false;
        }
        //move snake down
        if (e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_S && (!moveUp)) {
            moveDown = true;
            moveRight = false;
            moveLeft = false;
        }
        //move snake right
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_D && (!moveLeft)) {
            moveRight = true;
            moveUp = false;
            moveDown = false;
        }
        //move snake left
        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_A && (!moveRight)) {
            moveLeft = true;
            moveUp = false;
            moveDown = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


}