package bg.tu_varna.sit.b1.f22621620.source.field.generator;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.field.generator.interfaces.GenerateLevel;

import java.util.Random;

public class Generator implements GenerateLevel {
    private int x;
    private int y;
    private int monsters;
    private int treasures;
    private Field field;

    public Generator() {
        x = 10;
        y = 10;
        monsters = 2;
        treasures = 2;
    }

    @Override
    public void generateLevel(int level) {
        fillValues(level);

        Random diceRoll = new Random();
        char[][] grid = new char[x][y];
        grid[0][0] = 'P';
        grid[x-1][y-1] = 'X';
        int treasuresCount = treasures;
        int monstersCount = monsters;

        for (int i = 1; i < x - 1; i++) {
            for (int j = 1; j < y - 1; j++) {
                int value = diceRoll.nextInt(5);
                switch (value) {
                    case 0,1,2 -> {
                        grid[i][j] = '.';
                    }
                    case 3,4 -> {
                        grid[i][j] = '#';
                    }
                    case 5 -> {
                        int coinFlip = diceRoll.nextInt(2);
                        switch (coinFlip) {
                            case 0 -> {
                                if (treasuresCount <= treasures) {
                                    grid[i][j] = 'T';
                                    treasuresCount++;
                                }
                            }
                            case 1 -> {
                                if (monstersCount <= monsters) {
                                    grid[i][j] = 'M';
                                    monstersCount++;
                                }
                            }
                        }
                    }
                }
            }
        }

        if (treasuresCount < treasures) {
            for (int i = 0; i < treasures - treasuresCount; i++) {
                int hx = diceRoll.nextInt(x-2);
                int hy = diceRoll.nextInt(y-2);
                if (hx == 0 && hy == 0) {
                    hx++;
                }
                else grid[hx][hy] = 'T';
            }
        }
        if (monstersCount < monsters) {
            for (int i = 0; i < monsters - monstersCount; i++) {
                int hx = diceRoll.nextInt(x-2);
                int hy = diceRoll.nextInt(y-2);
                if (hx == 0 && hy == 0) {
                    hx++;
                }
                else grid[hx][hy] = 'M';
            }
        }
    }

    public void fillValues(int level) {
        if (level == 2) {
            x = 15;
            y = 10;
            monsters = 3;
            treasures = 2;
        }
        else if(level > 1) {
            int hX = 15;
            int hY = 10;
            int hMonsters = 3;
            int hTreasures = 2;

            for (int i = 2; i < level; i++) {
                x += hX;
                y += hY;
                monsters += hMonsters;
                treasures += hTreasures;

                hX = x;
                hY = y;
                hMonsters = monsters;
                hTreasures = treasures;
            }
        }
    }
}
