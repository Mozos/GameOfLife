package life;

public class Universe {

    private static int size = 0;
    private static int generation = 0;
    private static char[][] universe;

    public Universe(int size) {
        Universe.size = size;
    }

    public static int getSize() {
        return size;
    }

    public static int getGeneration() {
        return generation;
    }

    public static char[][] getUniverse() {
        return universe.clone();
    }

    public void setUniverse(char[][] universe) {
        Universe.universe = universe.clone();
        generation++;
    }

}
