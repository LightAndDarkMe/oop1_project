package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.GameMapDataManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class GameMapData {
    private static GameMapData instance = null;
    private File file = null;
    private GameMapDataManager appDataManager;

    private GameMapData() {}

    public static GameMapData getInstance() {
        if (instance == null) {
            instance = new GameMapData();
        }
        return instance;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void load(File file) throws Exception {
        this.file = file;
        updateAppDataManager();
        appDataManager.load();
    }

    public void unload() throws Exception {
        appDataManager.unload();
    }

    public void save(File file) throws Exception {
        if (Objects.isNull(file)) {
            throw new Exception("No file open!");
        }

        switch (this.file.getName()) {
            case ".xml" -> {

            }

            default -> {
                throw new FileNotFoundException("File couldn't be found!");
            }
        }
    }

    public void updateAppDataManager() throws FileNotFoundException {
        if (file == null) {
            throw new FileNotFoundException("File couldn't be found!");
        }
    }
}
