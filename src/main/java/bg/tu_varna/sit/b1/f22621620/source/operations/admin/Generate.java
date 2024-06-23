package bg.tu_varna.sit.b1.f22621620.source.operations.admin;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.login.UnobtainedAdminAccessException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.InvalidLevelException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.SyntaxErrorException;
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
            throw new SyntaxErrorException("Syntax error! Should be: generate <level>");
        }
        if (!args.get(0).matches("[0-9]")) {
            throw new InvalidLevelException("Invalid level!");
        }
        if (!GameData.getInstance().isAdmin()) {
            throw new UnobtainedAdminAccessException("You do NOT have admin access!");
        } else {
            Generator generator = new Generator();
            generator.generate_level(Integer.parseInt(args.get(0)));
            System.out.println("New map was generated successfully!");
        }
    }
}
