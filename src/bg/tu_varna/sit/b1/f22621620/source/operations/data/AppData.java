package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.AppDataManager;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;

public class AppData {
    private static AppData instance = null;
    private File file = null;
    private AppDataManager appDataManager;

    private AppData() {}

    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
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
