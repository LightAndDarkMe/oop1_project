package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Down implements ExecutableOperation {
    @Override
    public void execute() {
        if (!GameData.getInstance().isStarted()) {
            throw new RuntimeException("Game has not started yet! Use play");
        }

    }
}
