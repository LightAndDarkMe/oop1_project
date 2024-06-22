package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.Operation;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Help implements ExecutableOperation {
    @Override
    public void execute() {
        for (Operation operation : Operation.values()) {
            System.out.printf("%-15s%s\n", operation.getOperation().toUpperCase(), operation.getDescription());
        }
    }
}
