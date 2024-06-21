package bg.tu_varna.sit.b1.f22621620.source.field;

import java.util.List;

public class Field{
    private List<String> grid;
    private final int x;
    private final int y;
    private final int level;


    public Field() {
        x = 10;
        y = 10;
        level = 1;
    }

    public Field(List<String> grid, int x, int y, int level) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.level = level;
    }

    public List<String> getGrid() {
        return grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }

    public void setGrid(List<String> grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return String.join("\n", grid);
    }
}
