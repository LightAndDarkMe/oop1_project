package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Close implements ExecutableOperation {
    public void execute() throws FileNotFoundException {
        if(Objects.isNull(GameData.getInstance().getFile())) {
            throw new FileNotFoundException("No file to open!");
        }

        GameData.getInstance().setFile(null);
        System.out.println("Closed!");
    }
}
