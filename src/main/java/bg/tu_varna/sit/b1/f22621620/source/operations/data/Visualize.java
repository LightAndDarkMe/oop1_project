package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.FieldNotFoundException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.gameplay.GameNotStartedException;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.Objects;

public class Visualize implements ExecutableOperation {

    @Override
    public void execute() {
        if (!GameData.getInstance().isStarted()) {
            throw new GameNotStartedException("The game has not been started!");
        }

        if (Objects.isNull(GameData.getInstance().getCurrentField())) {
            throw new FieldNotFoundException("Field not found!");
        }
        System.out.println(GameData.getInstance().getCurrentField());
    }
}
