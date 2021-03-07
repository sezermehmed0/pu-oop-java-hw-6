package Controllers;

import game.Game;
import game.Shape;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonHandler implements ActionListener {

    private Game theApp;
    private int action;

    public static final int[] coordinateX = new int[400];
    public static final int[] coordinateY = new int[400];

    public static boolean inGame = true;
    public static boolean executed = false;




    //creates new timer
    Timer timer = new Timer(350, this);

    public ButtonHandler(Game theApp, int action) {
        this.theApp = theApp;
        this.action = action;
        startGame();
    }

    /**
     * This method contains implementations for the buttons and radio buttons
     * @param e Object of ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //button 'Start Game'
        if (this.action == 1) {
            move();
            eatFruit();
            bodyImpact();
            wallImpact();
            this.theApp.repaint();
            timer.start();
        }
        //Button 'Reset'
        if (this.action == 2) {
            resetGame();
        }
        //Radio Button 'Easy'
        if (Game.option1.isSelected()) {
            timer.setDelay(300);
        }
        //Radio Button 'Medium'
        if (Game.option2.isSelected()) {
            timer.setDelay(200);
        }
        //Radio Button 'Hard'
        if (Game.option3.isSelected()) {
            timer.setDelay(100);
        }
    }

    //starts the game
    public void startGame() {
        game.Snake.snakeParts = 4;

        Game.option2.setSelected(true);
        createSnake();
        randomFruit();

    }

    /**
     * This method,draws the fruit on random position in the grid
     */
    public void randomFruit() {

        ArrayList<Integer> fruitCoordinatesX = new ArrayList<>();
        ArrayList<Integer> fruitCoordinatesY = new ArrayList<>();

        game.Fruit.size = 20;
        int start = 5;

        for (int i = 0; i < 20; i++) {
            fruitCoordinatesX.add(start);
            fruitCoordinatesY.add(start);
            start += 30;
        }

        Collections.shuffle(fruitCoordinatesX);
        Shape.positionX = fruitCoordinatesX.get(0);
        Collections.shuffle(fruitCoordinatesY);
        Shape.positionY = fruitCoordinatesY.get(0);
    }

    /**
     * This method, draws the snake head in the grid
     */
    public void createSnake() {

        for (int index = 1; index <= game.Snake.snakeParts; index++) {
            coordinateX[index] = 0;
            coordinateY[index] = 0;
        }

        inGame = true;

        game.Snake.size = 30;
        Game.gameOver.setText("");

        // sets snake's initial position and direction moving
        coordinateX[0] = 300;
        coordinateY[0] = 300;
        keyController.moveLeft = false;
        keyController.moveRight = true;
        keyController.moveUp = false;
        keyController.moveDown = false;

        //appending the snake body in the array
        for (int i = 1; i <= game.Snake.snakeParts; i++) {
            coordinateX[i] -= coordinateX[0] - 30;
            coordinateY[i] = coordinateY[0];
        }
    }

    /**
     * This method, checks for snake collision with the wall
     */
    public void wallImpact() {
        if (coordinateX[0] >= 600 || coordinateX[0] < 0 || coordinateY[0] >= 600 || coordinateY[0] < 0) {
            gameOver();
        }
    }

    /**
     *  This method, checks if snake  eats the fruit, also change points added according to the difficulty selected
     *
      **/

    public void eatFruit() {
        if (coordinateX[0] == Shape.positionX - 5 && coordinateY[0] == Shape.positionY - 5) {
            keyController.fruitsEaten += 1;
            if (Game.option1.isSelected()) {
                keyController.scorePoints += 50;
            }
            if (Game.option2.isSelected()) {
                keyController.scorePoints += 30;
            }
            if (Game.option3.isSelected()) {
                keyController.scorePoints += 15;
            }
            //draws the fruit again and adds one more snake body part
            randomFruit();
            Game.fruitScore.setText(String.valueOf(keyController.fruitsEaten));
            Game.score_score.setText(String.valueOf(keyController.scorePoints));
            game.Snake.snakeParts++;
        }
    }

    /**
     * This method, checks for snake collision with its own body
     */
    public void bodyImpact() {
        for (int i = 1; i < game.Snake.snakeParts; i++) {
            if (coordinateX[0] == coordinateX[i] && coordinateY[0] == coordinateY[i]) {
                gameOver();
            }
        }
    }

    /**
     * This method, should move snake by calling keyListener, but it didn't works for some reason
     */
    public void move() {
        for (int index = game.Snake.snakeParts; index > 0; index--) {
            coordinateX[index] = coordinateX[(index - 1)];
            coordinateY[index] = coordinateY[(index - 1)];
        }

        if (keyController.moveLeft) {
            coordinateX[0] -= 30;
        }
        if (keyController.moveRight) {
            coordinateX[0] += 30;
        }
        if (keyController.moveUp) {
            coordinateY[0] -= 30;
        }
        if (keyController.moveDown) {
            coordinateY[0] += 30;
        }
    }

    /**
     *This method, resets everything on their original state
     */

    public void resetGame() {
        timer.stop();
        inGame = true;
        executed = false;
        Game.option2.setSelected(true);
        Game.gameOver.setText("");
        keyController.fruitsEaten = 0;
        keyController.scorePoints = 0;
        Game.fruitScore.setText(String.valueOf(keyController.fruitsEaten));
        Game.score_score.setText(String.valueOf(keyController.scorePoints));
        startGame();
    }

    /**
     * This method, is printing "Game over" message after player hits the wall or snake hits own body
     */
    public void gameOver() {
        if (!executed) {
            game.Snake.size = 0;
            game.Fruit.size = 0;
            Game.gameOver.setText("Game Over!");
            timer.stop();
            inGame = false;
            executed = true;
        }
    }
}