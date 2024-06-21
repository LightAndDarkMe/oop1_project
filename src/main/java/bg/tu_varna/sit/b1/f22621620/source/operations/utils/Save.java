package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Save implements ExecutableOperation {
    @Override
    public void execute() {
        GameData.getInstance().unload();
        System.out.println("Saved!");
    }
}
