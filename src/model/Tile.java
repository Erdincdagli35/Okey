package model;

public class Tile {
    private final Color color;
    private final int number; //1-13 between (fake okey should be 0)
    private final boolean isFake;

    public Tile(Color color, int number, boolean isFake) {
        this.color = color;
        this.number = number;
        this.isFake = isFake;
    }

    public Color getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFake() {
        return isFake;
    }

    @Override
    public String toString() {
        return "Tile{" +
                "color=" + color +
                ", number=" + number +
                ", isFake=" + isFake +
                '}';
    }
}
