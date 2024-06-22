package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Play implements ExecutableOperation {
    @Override
    public void execute() {
        if (!GameData.getInstance().isStarted()) {
            GameData.getInstance().setStarted(true);
            System.out.println("Game started successfully!");
        } else {
            throw new RuntimeException("The game is already started.");
        }
    }
}
