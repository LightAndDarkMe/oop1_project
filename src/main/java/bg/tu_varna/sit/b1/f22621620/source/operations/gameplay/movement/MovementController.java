package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.GameEngine;

import java.util.ArrayList;

public class MovementController {
    private int currentX = GameData.getInstance().getPlayerPosX();
    private int currentY = GameData.getInstance().getPlayerPosY();
    private int dx;
    private int dy;

    public void move(String direction) {
        switch (direction) {
            case "up" -> {
                if (currentX == 0) {
                    throw new RuntimeException("Cannot leave the playing field!");
                }
                dx--;
            }
            case "down" -> {
                if (currentX == GameData.getInstance().getCurrentField().getX() - 1) {
                    throw new RuntimeException("Cannot leave the playing field!");
                }
                dx++;
            }
            case "left" -> {
                if (currentY == 0) {
                    throw new RuntimeException("Cannot leave the playing field!");
                }
                dy--;
            }
            case "right" -> {
                if (currentY == GameData.getInstance().getCurrentField().getY() - 1) {
                    throw new RuntimeException("Cannot leave the playing field!");
                }
                dy++;
            }
            default -> throw new RuntimeException("Incorrect direction!");
        }

        char currentSymbol = GameData.getInstance().getCurrentField().getGrid().get(currentX + dx).charAt(currentY + dy);

        switch (currentSymbol) {
            case '#' -> {
                GameEngine.getInstance().onWallCollision();
            }
            case 'M' -> {
                GameEngine.getInstance().onMonsterCollision();
                move();
            }
            case 'T' -> {
                GameEngine.getInstance().onTreasureCollision();
                move();
            }
            case 'X' -> {
                GameEngine.getInstance().onExitCollision();
            }
            case '.' -> {
                move();
            }
        }
    }

    private void move() {
        ArrayList<String> grid = new ArrayList<>(GameData.getInstance().getCurrentField().getGrid());
        char[] gridArray = grid.get(currentX).toCharArray();
        gridArray[currentY] = '.';
        grid.set(currentX, String.valueOf(gridArray));

        GameData.getInstance().setPlayerPosX(currentX + dx);
        GameData.getInstance().setPlayerPosY(currentY + dy);
        gridArray = grid.get(currentX + dx).toCharArray();
        gridArray[currentY + dy] = 'P';
        grid.set(currentX + dx, String.valueOf(gridArray));

        GameData.getInstance().getCurrentField().setGrid(grid);
    }
}
