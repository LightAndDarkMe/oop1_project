package bg.tu_varna.sit.b1.f22621620.source.operations.admin;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.login.AdminAccessObtainedException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.login.IncorrectPasswordException;
import bg.tu_varna.sit.b1.f22621620.source.exceptions.operations.SyntaxErrorException;
import bg.tu_varna.sit.b1.f22621620.source.operations.data.GameData;
import bg.tu_varna.sit.b1.f22621620.source.operations.interfaces.ExecutableOperation;

import java.util.List;
import java.util.Objects;

public class Login implements ExecutableOperation {
    private final List<String> args;

    public Login(List<String> args) {
        this.args = args;
    }

    @Override
    public void execute() {
        if (GameData.getInstance().isAdmin()) {
            throw new AdminAccessObtainedException("You already have admin access granted!");
        }
        if (args.size() != 1) {
            throw new SyntaxErrorException("Syntax error! Should be: login <password>");
        }
        if (!Objects.equals(args.get(0), "I<3c++")) {
            throw new IncorrectPasswordException("Wrong password!");
        }
        GameData.getInstance().setAdmin(true);
        System.out.println("Login was successful!");
    }
}
