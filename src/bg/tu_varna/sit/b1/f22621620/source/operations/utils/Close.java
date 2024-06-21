package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameMapData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Close implements ExecutableOperation {
    public void execute() throws FileNotFoundException {
        if(Objects.isNull(GameMapData.getInstance().getFile())) {
            throw new FileNotFoundException("No file to open!");
        }

        GameMapData.getInstance().setFile(null);
        System.out.println("Closed!");
    }
}
