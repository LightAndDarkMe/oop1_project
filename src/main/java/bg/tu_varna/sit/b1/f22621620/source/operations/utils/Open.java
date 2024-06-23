package bg.tu_varna.sit.b1.f22621620.source.operations.utils;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.SyntaxErrorException;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Open implements ExecutableOperation {
    private final String DEFAULT_PATH = ".\\src\\main\\java\\bg\\tu_varna\\sit\\b1\\f22621620\\source\\files\\".replace("\\", File.separator);
    private final List<String> args;

    public Open(List<String> args) {
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.size() != 1) {
            throw new SyntaxErrorException("Syntax error! Should be: open <path>");
        }
        File file = new File((args.get(0).contains(File.separator)) ? args.get(0) : DEFAULT_PATH.concat(args.get(0)));
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Created file " + file.getName() + " successfully!");
            return;
        }
        GameData.getInstance().load(file);
        System.out.println("File " + file.getName() + " opened successfully!");
    }
}
