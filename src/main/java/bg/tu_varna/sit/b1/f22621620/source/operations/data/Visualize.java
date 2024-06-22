package bg.tu_varna.sit.b1.f22621620.source.operations.data;

import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

public class Visualize implements ExecutableOperation {

    @Override
    public void execute() {
        if (GameData.getInstance().getCurrentField() != null) {
            System.out.println(GameData.getInstance().getCurrentField());
        } else {
            throw new RuntimeException("No map is present!");
        }
    }
}
