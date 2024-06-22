package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Stats implements ExecutableOperation {

    @Override
    public void execute() throws Exception {
        if (!GameData.getInstance().isStarted()) {
            throw new RuntimeException("The game has not started!");
        }
        System.out.println(GameData.getInstance().getPlayer());
    }
}
