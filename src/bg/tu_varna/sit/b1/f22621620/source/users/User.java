package bg.tu_varna.sit.b1.f22621620.source.users;

public class User {
    private String name;
    private String password; //not sure? idk, will change later if needed
    private UserType type;

    public User(String name, UserType type) {
        this.name = name;
        this.type = type;
    }

    public User(String name, String password, UserType type) {
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserType getType() {
        return type;
    }
}
