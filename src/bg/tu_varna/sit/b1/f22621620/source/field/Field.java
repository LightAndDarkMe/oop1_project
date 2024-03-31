package bg.tu_varna.sit.b1.f22621620.source.field;

import java.util.Arrays;

public class Field{
    private char[][] grid;

    public Field() {

    }

    public Field(char[][] grid) {
        this.grid = grid;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

//    Fix later!!!
    @Override
    public String toString() {
        return "Field{" +
                "grid=" + Arrays.toString(grid) +
                '}';
    }
}
