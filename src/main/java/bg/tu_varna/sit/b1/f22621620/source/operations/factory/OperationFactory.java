package bg.tu_varna.sit.b1.f22621620.source.operations.factory;

import bg.tu_varna.sit.b1.f22621620.source.operations.Operation;
import bg.tu_varna.sit.b1.f22621620.source.operations.admin.Generate;
import bg.tu_varna.sit.b1.f22621620.source.operations.admin.Login;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.Stats;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.Visualize;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.Play;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement.Down;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement.Left;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement.Right;
import bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement.Up;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;
import bg.tu_varna.sit.b1.f22621620.source.operations.utils.*;

import java.util.List;

public class OperationFactory {
    private static OperationFactory instance = null;

    private OperationFactory() {
    }

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

            case PLAY -> new Play();
            case UP -> new Up();
            case DOWN -> new Down();
            case LEFT -> new Left();
            case RIGHT -> new Right();
            case VISUALIZE -> new Visualize();
            case STATS -> new Stats();
            case GENERATE -> new Generate(args);
            case LOGIN -> new Login(args);
        };
    }
}
