package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.File;
import java.util.List;

public class SaveAs implements ExecutableOperation {
    private List<String> args;

    public SaveAs(List<String> args) {
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.size() != 1) {
            throw new RuntimeException("Syntax error, Should be: save as <path>");
        }
        File file = new File(args.get(0));
        GameData.getInstance().unload(file);
        System.out.println("File " + file.getName() + " saved successfully!");
    }
}
