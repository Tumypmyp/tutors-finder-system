package user;

import user.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBase {
    private HashMap<String, User> users = new HashMap<>();
    private List<Tutor> tutors = new ArrayList<>();
    private List<Parent> parents = new ArrayList<>();
    public List<Book> books = new ArrayList<>();

    User login(String username, String password) {
        if (users.get(username) != null && users.get(username).checkPassword(password)) {
            return users.get(username);
        }
        return null;
    }
    
    //    Factory method
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
            case "Parent" -> {
                Parent parent = new Parent(username, password, this);
                parents.add(parent);
                user = parent;
            }
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

    public List<Parent> getParents() {
        return parents;
    }

}
