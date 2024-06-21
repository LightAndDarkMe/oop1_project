package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameMapData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.File;
import java.util.List;

public class SaveAs implements ExecutableOperation {
    private List<String> args;
    private final String PATH = ".\\src\\main\\java\\bg\\tu_varna\\sit\\b1\\f22621620\\files\\";

    public SaveAs(List<String> args) {
        this.args = args;
    }

    @Override
    public void execute() throws Exception {
        GameMapData.getInstance().save(new File(PATH.concat(args.get(0))));
        System.out.println("File " + args.get(0) + " saved successfully!");
    }
}