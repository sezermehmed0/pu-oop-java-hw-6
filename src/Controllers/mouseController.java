package Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class mouseController implements MouseListener {

    /**
     * This method, use mouseListener that compares snake's position and mouse click position and changes snake's moving direction
     * @param e Object of MouseEvent
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (ButtonHandler.inGame) {
            if (Controllers.keyController.moveUp && e.getX() > ButtonHandler.coordinateX[0] && (e.getY() > 0 && e.getY() < 600)) {
                Controllers.keyController.moveRight = true;
                Controllers.keyController.moveUp = false;
            }
            else if (Controllers.keyController.moveUp && e.getX() < ButtonHandler.coordinateX[0] && (e.getY() > 0 && e.getY() < 600)) {
                Controllers.keyController.moveLeft = true;
                Controllers.keyController.moveUp = false;
            }
            else if (Controllers.keyController.moveDown && e.getX() > ButtonHandler.coordinateX[0] && (e.getY() > 0 && e.getY() < 600)) {
                Controllers.keyController.moveRight = true;
                Controllers.keyController.moveDown = false;
            }
            else if (Controllers.keyController.moveDown && e.getX() < ButtonHandler.coordinateX[0] && (e.getY() > 0 && e.getY() < 600)) {
                Controllers.keyController.moveLeft = true;
                Controllers.keyController.moveDown = false;
            }
            else if (Controllers.keyController.moveLeft && e.getY() > ButtonHandler.coordinateY[0] && (e.getX() > 0 && e.getX() < 600)) {
                Controllers.keyController.moveDown = true;
                Controllers.keyController.moveLeft = false;
            }
            else if (Controllers.keyController.moveLeft && e.getY() < ButtonHandler.coordinateY[0] && (e.getX() > 0 && e.getX() < 600)) {
                Controllers.keyController.moveUp = true;
                Controllers.keyController.moveLeft = false;
            }
            else if (Controllers.keyController.moveRight && e.getY() > ButtonHandler.coordinateY[0] && (e.getX() > 0 && e.getX() < 600)) {
                Controllers.keyController.moveDown = true;
                Controllers.keyController.moveRight = false;
            }
            else if (Controllers.keyController.moveRight && e.getY() < ButtonHandler.coordinateY[0] && (e.getX() > 0 && e.getX() < 600)) {
                Controllers.keyController.moveUp = true;
                Controllers.keyController.moveRight = false;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) { }

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) { }
}