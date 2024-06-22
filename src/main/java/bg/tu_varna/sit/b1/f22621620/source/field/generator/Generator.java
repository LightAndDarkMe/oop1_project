package bg.tu_varna.sit.b1.f22621620.source.field.generator;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.field.generator.interfaces.GenerateLevel;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;

import java.util.Arrays;
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
    public void generate(int level) {
        fillValues(level);

        //Create DiceRoll / CoinFlip classes instead of this thing
        Random diceRoll = new Random();
        //Char Array => To List<String>
        char[][] grid = new char[x][y];
        int treasuresCount = 0;
        int monstersCount = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int value = diceRoll.nextInt();
                value = (value < 0) ? value * -1 : value;
                value %= 6;
                switch (value) {
                    case 0, 1, 2, 3 -> {
                        grid[i][j] = '.';
                    }
                    case 4 -> {
                        grid[i][j] = '#';
                    }
                    case 5 -> {
                        int coinFlip = diceRoll.nextInt();
                        coinFlip = (coinFlip < -1) ? coinFlip * -1 : coinFlip;
                        coinFlip %= 21;
                        switch (coinFlip) {
                            case 0 -> {
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
                            default -> {
                                grid[i][j] = '.';
                            }
                        }
                    }
                }
            }
        }

        grid[0][0] = 'P';
        grid[x - 1][y - 1] = 'X';

        if (treasuresCount < treasures) {
            for (int i = 0; i < treasures - treasuresCount; i++) {
                int hx = diceRoll.nextInt(x - 2);
                int hy = diceRoll.nextInt(y - 2);
                if (hx == 0 && hy == 0) {
                    hx++;
                } else grid[hx][hy] = 'T';
            }
        }
        if (monstersCount < monsters) {
            for (int i = 0; i < monsters - monstersCount; i++) {
                int hx = diceRoll.nextInt(x - 2);
                int hy = diceRoll.nextInt(y - 2);
                if (hx == 0 && hy == 0) {
                    hx++;
                } else grid[hx][hy] = 'M';
            }
        }

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

        field = new Field(Arrays.stream(gridBuilder.toString().split("/")).toList(), x, y, level);
        GameData.getInstance().setCurrentField(field);
        System.out.println(field);
    }

    public void fillValues(int level) {
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
}
