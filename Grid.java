package life;

import javax.swing.*;
import java.awt.*;

public class Grid{

    private final int size = Universe.getSize();
    private final JPanel grid = new JPanel();
    private final JPanel[][] cells = new JPanel[size][size];

    public Grid() {
        grid.setLayout(new GridLayout(size, size, 1, 1));
        grid.setBackground(Color.BLACK);
        createCells();
        generateCells();
        addCells();
    }

    private void createCells() {
        for (int row = 0; row < cells.length; row++) {
            for (int column = 0; column < cells[row].length; column++) {
                cells[row][column] = new JPanel();
            }
        }
    }

    public void generateCells() {
        char[][] universe = Universe.getUniverse();
        for (int row = 0; row < universe.length; row++) {
            for (int column = 0; column < universe[row].length; column++) {
                if (universe[row][column] == 'O') {
                    cells[row][column].setBackground(Color.BLACK);
                } else {
                    cells[row][column].setBackground(Color.WHITE);
                }
            }
        }
    }

    private void addCells() {
        for (JPanel[] row : cells) {
            for (JPanel cell : row) {
                grid.add(cell);
            }
        }
    }

    public JPanel getGrid() {
        return grid;
    }
}
