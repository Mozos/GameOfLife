package life;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class GameOfLife extends JFrame {

    private static final String GENERATION = "Generation #";
    private static final String ALIVE = "Alive: ";
    private final JLabel generationLabel;
    private final JLabel aliveLabel;
    private final Grid grid;

    public GameOfLife() {
        super("Game of Life");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Universe.getSize() * 15, Universe.getSize() * 15 + 50);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

        generationLabel = new JLabel(GENERATION + Universe.getGeneration());
        generationLabel.setName("GenerationLabel");

        aliveLabel = new JLabel(ALIVE + Controller.getAlive());
        aliveLabel.setName("AliveLabel");

        grid = new Grid();

        add(generationLabel);
        add(aliveLabel);
        add(grid.getGrid());

        setVisible(true);
    }

    public void update(Universe universe) throws InterruptedException {
        while (isVisible()) {
            Controller.generateUniverse(universe);
            generationLabel.setText(GENERATION + Universe.getGeneration());
            aliveLabel.setText(ALIVE + Controller.getAlive());
            grid.generateCells();
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
