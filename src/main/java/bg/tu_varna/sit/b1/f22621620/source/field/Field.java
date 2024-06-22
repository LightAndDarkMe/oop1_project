package bg.tu_varna.sit.b1.f22621620.source.field;

import java.util.List;

public class Field {
    private List<String> grid;
    private final int x;
    private final int y;
    private int level;

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

    public void levelUp() {
        this.level++;
    }

    public void setGrid(List<String> grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        return String.join("\n", grid)
                .replaceAll("[PMTX#.]", "$0 ")
                .replace("P", "\u001B[32mP\u001B[0m")  //green
                .replace("M", "\u001B[31mM\u001B[0m")  //red
                .replace("T", "\u001B[33mT\u001B[0m")  //yellow
                .replace("#", "\033[1;37m#\u001B[0m")  //bold white
                .replace("X", "\u001B[32mX\u001B[0m"); //green
    }
}
