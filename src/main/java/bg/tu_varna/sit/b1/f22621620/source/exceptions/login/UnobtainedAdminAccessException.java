package bg.tu_varna.sit.b1.f22621620.source.exceptions.login;

import bg.tu_varna.sit.b1.f22621620.source.exceptions.LoginException;

public class UnobtainedAdminAccessException extends LoginException {
    public UnobtainedAdminAccessException(String message) {
        super(message);
    }
}
