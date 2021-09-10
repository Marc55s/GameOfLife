package ms.gol;

import java.awt.Color;
import java.awt.Graphics;

public class Computation {

    public static Color bl = Color.BLACK;
    public static Color wh = Color.white;
    private int[][] grid;
    private boolean compute = true;
    private final int gridSize;

    {
        gridSize = (int) (GameOfLife.WIDTH * 0.1);
        grid = new int[gridSize][gridSize];
    }

    public Computation() {
        if(GameOfLife.generator == 0)
            gridGenerator();
    }

    public void darkmode() {
        bl = Color.WHITE;
        wh = Color.BLACK;
    }

    public void whitemode() {
        bl = Color.BLACK;
        wh = Color.WHITE;
    }

    public void draw(Graphics g) {
        int squareSize = (39 - 1) / 2 / 2;
        int squareScale = 40 / 2 / 2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    g.setColor(bl);
                } else {
                    g.setColor(wh);
                }
                g.fillRect(i * squareScale, j * squareScale, squareSize, squareSize);
            }
        }
        //Computation of the next Generation
        if (compute)
            grid = computationNextGen(grid);
    }

    private int[][] computationNextGen(int[][] old) {
        int[][] next = new int[gridSize][gridSize];
        for (int i = 0; i < old.length; i++) {
            for (int j = 0; j < old.length; j++) {
                int state = old[i][j];
                int neighbours = countNeighbours(grid, i, j);

                //Rules
                if (state == 0 && neighbours == 3) {
                    next[i][j] = 1;
                } else if (state == 1 && (neighbours < 2 || neighbours > 3)) {
                    next[i][j] = 0;
                } else {
                    next[i][j] = state;
                }
            }
        }
        return next;
    }

    private int countNeighbours(int[][] grid, int x, int y) {
        int sum = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                int col = (x + i + gridSize) % gridSize;
                int row = (y + j + gridSize) % gridSize;
                sum += grid[col][row];
            }
        }
        sum -= grid[x][y];
        return sum;
    }

    private void gridGenerator() {
        grid = new int[gridSize][gridSize];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = (int) Math.round(Math.random());
            }
        }
    }


    public int[][] getGrid() {
        return grid;
    }

    public int getGridSize() {
        return gridSize;
    }

    public void setCompute(boolean compute) {
        this.compute = compute;
    }
}
