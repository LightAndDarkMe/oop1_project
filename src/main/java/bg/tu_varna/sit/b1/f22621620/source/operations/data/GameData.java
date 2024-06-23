package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.characters.playercharacter.PlayerCharacter;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.FieldNotFoundException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.GameFileNotFoundException;
import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.files.read.Reader;
import bg.tu_varna.sit.b1.f22621620.source.files.write.Writer;

import java.io.File;
import java.util.Objects;

public class GameData {
    private static GameData instance = null;
    private File file = null;
    private Field currentField;
    private PlayerCharacter player;
    private boolean isStarted = false;
    private boolean isAdmin = false;
    private int playerPosX = 0;
    private int playerPosY = 0;

    private GameData() {
    }

    public static GameData getInstance() {
        if (instance == null) {
            instance = new GameData();
        }
        return instance;
    }

    public File getFile() {
        return file;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    public PlayerCharacter getPlayer() {
        return player;
    }

    public void setPlayer(PlayerCharacter player) {
        this.player = player;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getPlayerPosX() {
        return playerPosX;
    }

    public void setPlayerPosX(int playerPosX) {
        this.playerPosX = playerPosX;
    }

    public int getPlayerPosY() {
        return playerPosY;
    }

    public void setPlayerPosY(int playerPosY) {
        this.playerPosY = playerPosY;
    }

    public void load(File file) {
        this.file = file;
        Reader reader = new Reader(file.getAbsolutePath());
        reader.read();
    }

    public void unload() {
        if (Objects.isNull(file)) {
            throw new GameFileNotFoundException("No game file found!");
        }
        if (Objects.isNull(currentField)) {
            throw new FieldNotFoundException("Field not found!");
        }
        Writer writer = new Writer(file.getAbsolutePath());
        writer.write(currentField);
    }

    public void unload(File file) {
        Writer writer = new Writer(file.getAbsolutePath());
        writer.write(currentField);
    }

    public void reset() {
        file = null;
        currentField = null;
        isStarted = false;
        playerPosX = 0;
        playerPosY = 0;
    }
}
