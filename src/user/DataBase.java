package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private HashMap<String, User> users = new HashMap<>();
    private List<Tutor> tutors = new ArrayList<>();

    User login(String username, String password) {
        if (users.get(username) != null && users.get(username).checkPassword(password)) {
            return users.get(username);
        }
        return null;
    }

    public User register(String username, String password, String userType) {
        if (users.get(username) != null) {
            System.out.println("Error: username already exists");
            return null;
        }
        if (password.length() < 8) {
            System.out.println("Error: password must be at least 8 characters");
            return null;
        }
        User user = null;
        switch (userType) {
            case "Parent" -> user = new Parent(username, password, this);
            case "Tutor" -> {
                user = new Tutor(username, password, this);
                tutors.add((Tutor) user);
            }
            case "Admin" -> user = new Admin(username, password, this);
            default -> {
                System.out.println("Unexpected value of userType: " + userType);
                return null;
            }
        }
        users.put(username, user);
        return user;
    }

    public List<Tutor> getTutors() {
        return tutors;
    }


}
