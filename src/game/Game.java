package game;
import Controllers.ButtonHandler;
import Controllers.keyController;
import Controllers.mouseController;
import Tile.TileGrid;

import javax.swing.*;
import java.awt.*;



public class Game extends JFrame {

    TileGrid tilegrid;
    Snake snake;
    Fruit fruit;

    /**
     * Creating JLabels, JRadioButtons that can be accessed from any class
     */
    public JLabel score = new JLabel("Score:   ");
    public static JLabel score_score = new JLabel("0");
    public JLabel fruits = new JLabel("Fruits eaten:   ");
    public static JLabel fruitScore = new JLabel("0");
    public static JLabel gameOver = new JLabel();


    public static JRadioButton option1 = new JRadioButton("Easy");
    public static JRadioButton option2 = new JRadioButton("Medium");
    public static JRadioButton option3 = new JRadioButton("Hard");


    public Game() {

        setTitle("Smoko - The Snake");
        setLayout(new BorderLayout());

        tilegrid = new TileGrid();
        snake = new Snake(0, 0, 0);
        fruit = new Fruit(0, 0, 0);

        JPanel tilePanel = new JPanel() {
            /**
             * Draws snake, fruit and the tile grid
             *
             * @param g Object of graphics
             */
            public void paintComponent(Graphics g) {
                snake.draw(g);
                fruit.draw(g);
                tilegrid.draw(g);
            }
        };

        //creates JPanels and setting their layout
        JPanel labels_panel = new JPanel();
        JPanel buttons_panel = new JPanel();

        tilePanel.setLayout(new GridBagLayout());
        labels_panel.setLayout(new GridBagLayout());
        buttons_panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;

        //adding components in the tilePanel using grid-bag-constraint
        constraints.gridy = 1;
        tilePanel.add(gameOver, constraints);
        constraints.gridy = 2;
        tilePanel.addMouseListener(new mouseController());

        //adds JRadioButtons in group
        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        //creating labels and adding them to buttons_panel using grid-bag-constraint
        JLabel difficulty = new JLabel("Game difficulty: ");
        buttons_panel.add(difficulty);
        constraints.insets = new Insets(10, 0, 10, 10);
        buttons_panel.add(option1, constraints);
        buttons_panel.add(option2, constraints);
        buttons_panel.add(option3, constraints);

        JButton start_button = new JButton("Start Game");
        JButton reset_button = new JButton("Reset");
        constraints.insets = new Insets(10, 0, 10, 0);
        buttons_panel.add(start_button, constraints);
        constraints.insets = new Insets(10, 20, 10, 0);
        buttons_panel.add(reset_button, constraints);
        constraints.insets = new Insets(10, 10, 10, 0);

        start_button.setPreferredSize(new Dimension(100, 30));


        JLabel startGame = new JLabel("Press 'Start Game' button to start playing");
        JLabel reset = new JLabel("Press 'Reset' button to reset the game");


        labels_panel.add(score, constraints);
        constraints.insets = new Insets(0, 0, 0, 300);
        labels_panel.add(score_score, constraints);
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 20, 0, 20);
        labels_panel.add(fruits, constraints);
        constraints.insets = new Insets(0, 20, 0, 20);
        labels_panel.add(fruitScore, constraints);
        constraints.insets = new Insets(50, 50, 10, 0);
        constraints.gridy = 3;
        constraints.insets = new Insets(40, 0, 0, 0);
        constraints.gridy = 8;
        labels_panel.add(startGame, constraints);
        constraints.gridy = 9;
        constraints.insets = new Insets(0, 0, 0, 0);
        labels_panel.add(reset, constraints);


        option1.setOpaque(false);
        option2.setOpaque(false);
        option3.setOpaque(false);


        add(tilePanel, BorderLayout.CENTER);
        add(labels_panel, BorderLayout.EAST);
        add(buttons_panel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);

        start_button.addActionListener(new ButtonHandler(this, 1));
        reset_button.addActionListener(new ButtonHandler(this, 2));
        addKeyListener(new keyController());
    }
}



