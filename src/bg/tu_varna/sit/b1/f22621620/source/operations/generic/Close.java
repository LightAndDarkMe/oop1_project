package bg.tu_varna.sit.b1.f22621620.source.operations.generic;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.AppData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Close implements ExecutableOperation {
    public void execute() throws FileNotFoundException {
        if(Objects.isNull(AppData.getInstance().getFile())) {
            throw new FileNotFoundException("No file to open!");
        }

        AppData.getInstance().setFile(null);
        System.out.println("Closed!");
    }
}
