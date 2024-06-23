package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.GameFileNotFoundException;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.Objects;

public class Close implements ExecutableOperation {
    public void execute() {
        if (Objects.isNull(GameData.getInstance().getFile())) {
            throw new GameFileNotFoundException("No game file found!");
        }

        GameData.getInstance().reset();
        System.out.println("Closed!");
    }
}
