package bg.tu_varna.sit.b1.f22621620.source.operations.gameplay.movement;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.GameNotStartedException;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Down extends Movement implements ExecutableOperation {
    @Override
    public void execute() {
        if (!GameData.getInstance().isStarted()) {
            throw new GameNotStartedException("The game has not been started!");
        }

        movementController.move("down");
        System.out.println(GameData.getInstance().getCurrentField());
        System.out.println();
    }
}
