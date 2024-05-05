package bg.tu_varna.sit.b1.f22621620.source.users;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static UserDatabase instance;
    private List<User> userList;

    private UserDatabase() {
        userList = new ArrayList<>();
    }

    public static UserDatabase getInstance() {
        if (instance == null) {
            instance = new UserDatabase();
        }
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void add(User user) {
            userList.add(user);
    }

    public void remove(User user) {
        userList.remove(user);
    }
}
