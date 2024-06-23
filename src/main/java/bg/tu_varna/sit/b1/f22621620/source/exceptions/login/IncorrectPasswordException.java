package bg.tu_varna.sit.b1.f22621620.source.exceptions.login;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.LoginException;

public class IncorrectPasswordException extends LoginException {
    public IncorrectPasswordException(String message) {
        super(message);
    }
}
