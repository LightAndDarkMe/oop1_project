package bg.tu_varna.sit.b1.f22621620.source.operations.generic;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.AppData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Exit implements ExecutableOperation {
    @Override
    public void execute() {
        System.exit(0);
    }
}
