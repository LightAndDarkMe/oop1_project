package bg.tu_varna.sit.b1.f22621620.source.operations.factory;

import bg.tu_varna.sit.b1.f22621620.source.operations.Operation;
import bg.tu_varna.sit.b1.f22621620.source.operations.generic.*;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.List;

public class OperationFactory {
    private static OperationFactory instance = null;

    private OperationFactory() {}

    public static OperationFactory getInstance() {
        if (instance == null) {
            instance = new OperationFactory();
        }
        return instance;
    }

    public ExecutableOperation getOperation(Operation operation, List<String> args) {
        return switch (operation) {
            case OPEN -> new Open(args);
            case CLOSE -> new Close();
            case SAVE -> new Save();
            case SAVE_AS -> new SaveAs(args);
            case HELP -> new Help();
            case EXIT -> new Exit();
        };
    }
}
