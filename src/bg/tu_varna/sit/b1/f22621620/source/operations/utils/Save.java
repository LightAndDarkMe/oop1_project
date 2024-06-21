package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameMapData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Save implements ExecutableOperation {
    @Override
    public void execute() throws Exception {
        GameMapData.getInstance().unload();
        System.out.println("Saved!");
    }
}
