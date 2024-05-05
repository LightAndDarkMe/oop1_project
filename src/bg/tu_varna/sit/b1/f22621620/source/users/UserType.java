package bg.tu_varna.sit.b1.f22621620.source.users;

public enum UserType {
    PLAYER("Player"),
    ADMIN("Admin");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
