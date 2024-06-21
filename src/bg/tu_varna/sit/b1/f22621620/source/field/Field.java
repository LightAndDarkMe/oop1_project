package bg.tu_varna.sit.b1.f22621620.source.field;

import java.util.List;

public class Field{
    private List<String> grid;
    private final int x;
    private final int y;

    public Field() {
        x = 10;
        y = 10;
    }

    public Field(List<String> grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
    }

    public List<String> getGrid() {
        return grid;
    }

    public void setGrid(List<String> grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return String.join("\n", grid);
    }
}
