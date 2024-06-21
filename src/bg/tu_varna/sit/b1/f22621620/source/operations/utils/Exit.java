package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Exit implements ExecutableOperation {
    @Override
    public void execute() {
        System.exit(0);
    }
}
