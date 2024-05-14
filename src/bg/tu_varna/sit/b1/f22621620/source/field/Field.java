package bg.tu_varna.sit.b1.f22621620.source.field;

import java.util.Arrays;

public class Field{
    private char[][] grid;
    private int x;
    private int y;

    public Field() {
        x = 10;
        y = 10;
    }

    public Field(char[][] grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                stringBuilder.append(grid[i][j]);
            }
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
