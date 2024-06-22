package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.field.Field;
import bg.tu_varna.sit.b1.f22621620.source.files.read.Reader;
import bg.tu_varna.sit.b1.f22621620.source.files.write.Writer;

import java.io.File;
import java.util.Objects;

public class GameData {
    private static GameData instance = null;
    private File file = null;
    private Field currentField;
    private boolean isStarted = false;
    private boolean isAdmin = false;

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

    public void setFile(File file) {
        this.file = file;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
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

    public void load(File file) {
        this.file = file;
        Reader reader = new Reader(file.getAbsolutePath());
        reader.read();
    }

    public void unload() {
        if (Objects.isNull(file)) {
            throw new RuntimeException("File not found!");
        }
        if (Objects.isNull(currentField)) {
            throw new RuntimeException("Field not found!");
        }
        Writer writer = new Writer(file.getAbsolutePath());
        writer.write(currentField);
    }

    public void unload(File file) {
        Writer writer = new Writer(file.getAbsolutePath());
        writer.write(currentField);
    }
}
