package bg.tu_varna.sit.b1.f22621620.source.operations.admin;

import bg.tu_varna.sit.b1.f22621620.source.field.generator.Generator;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.List;

public class Generate implements ExecutableOperation {

    private final List<String> args;

    public Generate(List<String> args) {
        this.args = args;
    }

    @Override
    public void execute() {
        if (args.size() != 1) {
            throw new RuntimeException("Syntax error, Should be: generate <level>");
        }
        if (!args.get(0).matches("[0-9]")) {
            throw new RuntimeException("The given level is not an integer!");
        }
        if (!GameData.getInstance().isAdmin()) {
            throw new RuntimeException("You do not have admin access!");
        } else {
            Generator generator = new Generator();
            generator.generate(Integer.parseInt(args.get(0)));
            System.out.println("New map was generated successfully!");
        }
    }
}
