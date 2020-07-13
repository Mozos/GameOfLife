package life;

public final class Main {

    public static void main(String[] args) throws InterruptedException {
        Universe universe = Controller.createUniverse(30);
        GameOfLife window = new GameOfLife();
        window.update(universe);
    }

}
