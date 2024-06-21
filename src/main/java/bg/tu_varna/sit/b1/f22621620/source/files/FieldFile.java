package bg.tu_varna.sit.b1.f22621620.source.files;

import java.io.File;

public abstract class FieldFile {
    protected final String DEFAULT_PATH = ".\\src\\main\\java\\bg\\tu_varna\\sit\\b1\\f22621620\\source\\files\\".replace("\\", File.separator);
    protected final String file;

    public FieldFile(String file) {
        if (file.contains(File.separator)) {
            this.file = file;
        }
        else {
            this.file = DEFAULT_PATH.concat(file);
        }
    }

    public String getFile() {
        return file;
    }
}
