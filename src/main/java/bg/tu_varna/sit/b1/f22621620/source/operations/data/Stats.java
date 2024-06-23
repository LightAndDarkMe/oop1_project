package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.GameNotStartedException;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Stats implements ExecutableOperation {

    @Override
    public void execute() throws Exception {
        if (!GameData.getInstance().isStarted()) {
            throw new GameNotStartedException("The game has not been started!");
        }
        System.out.println(GameData.getInstance().getPlayer());
    }
}
