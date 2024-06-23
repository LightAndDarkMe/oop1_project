package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.FileNotFoundException;

public class Save implements ExecutableOperation {
    @Override
    public void execute() throws FileNotFoundException {
        GameData.getInstance().unload();
        System.out.println("Saved!");
    }
}
