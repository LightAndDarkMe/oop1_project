package bg.tu_varna.sit.b1.f22621620.source.field.generator;

import bg.tu_varna.sit.b1.f22621620.source.dice.Dice;
import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.field.generator.interfaces.GenerateLevel;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;

import java.util.Arrays;

public class Generator implements GenerateLevel {
    private int x;
    private int y;
    private int monsters;
    private int treasures;

    public Generator() {
        x = 10;
        y = 10;
        monsters = 2;
        treasures = 2;
    }

    @Override
    public void generate_level(int level) {
        fillValues(level);

        Dice dice = new Dice();
        char[][] grid = new char[x][y];
        int treasuresCount = 0;
        int monstersCount = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int value = dice.rollDice(6);
                switch (value) {
                    case 1, 2, 3, 4 -> grid[i][j] = '.';
                    case 5 -> grid[i][j] = '#';
                    case 6 -> {
                        int d20 = dice.rollDice(20);
                        switch (d20) {
                            case 20 -> {
                                if (treasuresCount <= treasures) {
                                    grid[i][j] = 'T';
                                    treasuresCount++;
                                } else {
                                    grid[i][j] = '.';
                                }
                            }
                            case 1 -> {
                                if (monstersCount <= monsters) {
                                    grid[i][j] = 'M';
                                    monstersCount++;
                                } else {
                                    grid[i][j] = '#';
                                }
                            }
                            default -> grid[i][j] = '.';
                        }
                    }
                }
            }
        }

        if (treasuresCount < treasures) {
            fillMissingValues(grid, (treasures - treasuresCount), 'T');
        }
        if (monstersCount < monsters) {
            fillMissingValues(grid, (monsters - monstersCount), 'M');
        }

        grid[0][0] = 'P';
        grid[x - 1][y - 1] = 'X';

        GameData.getInstance().setCurrentField(conversion(grid, level));
        GameData.getInstance().setPlayerPosX(0);
        GameData.getInstance().setPlayerPosY(0);
    }

    private void fillValues(int level) {
        if (level == 2) {
            x = 15;
            y = 10;
            monsters = 3;
            treasures = 2;
        } else if (level > 1) {
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

    private void fillMissingValues(char[][] grid, int count, char c) {
        Dice dice = new Dice();
        for (int i = 0; i < count; i++) {
            int hx = dice.rollDice(x - 1);
            int hy = dice.rollDice(y - 1);
            grid[hx][hy] = c;
        }
    }

    private Field conversion(char[][] grid, int level) {
        StringBuilder gridBuilder = new StringBuilder();
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                gridBuilder.append(grid[i][j]);
            }
            if (i == x - 1) {
                break;
            }
            gridBuilder.append("/");
        }

        return new Field(Arrays.stream(gridBuilder.toString().split("/")).toList(), x, y, level);
    }
}
