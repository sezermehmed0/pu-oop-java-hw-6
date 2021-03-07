package Tile;

import java.awt.*;

public class TileGrid {

    int tileSize = 20;
    int rows = 30;
    int cols = 30;
    int gamePanelSize = 600;

    /**
     * This method, draws 20x20 grid
     * @param g Object of graphics
     */
    public void draw(Graphics g) {

            for (int x = 0; x <= tileSize; x++) {
                for (int y = 0; y <= tileSize; y++) {
                    g.drawLine(x * rows, 0, x * rows, gamePanelSize);
                    g.drawLine(0, y * cols, gamePanelSize, y * cols);
                }
            }
        }
    
