package bg.tu_varna.sit.b1.f22621620.source.operations.generic;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.AppData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Close implements ExecutableOperation {
    public void execute() throws Exception {
        AppData.getInstance().unload();
        System.out.println("Closed!");
    }
}
