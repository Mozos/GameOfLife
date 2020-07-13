package life;

import java.util.Random;

public class Controller {

    public static Universe createUniverse(int size) {
        Universe universe = new Universe(size);
        initializeUniverse(universe);
        return universe;
    }

    private static void initializeUniverse(Universe universe) {
        char[][] matrix = new char[Universe.getSize()][Universe.getSize()];
        Random random = new Random();

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                if (random.nextBoolean()) {
                    matrix[row][column] = 'O';
                } else {
                    matrix[row][column] = ' ';
                }
            }
        }

        universe.setUniverse(matrix);
    }

    public static void generateUniverse(Universe universe) {
        char[][] previousUniverse = Universe.getUniverse();
        char[][] nextUniverse = new char[Universe.getSize()][Universe.getSize()];

        for (int row = 0; row < Universe.getSize(); row++) {
            for (int column = 0; column < Universe.getSize(); column++) {
                int neighbors = 0;

                for (int r = row - 1; r <= row + 1; r++) {
                    for (int c = column - 1; c <= column + 1; c++) {
                        if (r == row && c == column) {
                            continue;
                        }

                        int ro = r < 0 ? Universe.getSize() - 1 : r == Universe.getSize() ? 0 : r;
                        int co = c < 0 ? Universe.getSize() - 1 : c == Universe.getSize() ? 0 : c;
                        if (previousUniverse[ro][co] == 'O') {
                            neighbors++;
                        }
                    }
                }

                if (previousUniverse[row][column] == 'O') {
                    if (neighbors < 2 || neighbors > 3) {
                        nextUniverse[row][column] = ' ';
                    } else {
                        nextUniverse[row][column] = 'O';
                    }
                } else {
                    if (neighbors == 3) {
                        nextUniverse[row][column] = 'O';
                    } else {
                        nextUniverse[row][column] = ' ';
                    }
                }
            }
        }

        universe.setUniverse(nextUniverse);
    }

    public static int getAlive() {
        int alive = 0;

        for (char[] row : Universe.getUniverse()) {
            for (char column : row) {
                if (column == 'O') {
                    alive++;
                }
            }
        }

        return alive;
    }
}
