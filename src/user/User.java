package user;

import database.DataBase;

public class User {
    private final String username;
    protected DataBase db;
    private String password;

    User(String username, String password, DataBase db) {
        this.username = username.toLowerCase();
        this.password = password;
        this.db = db;
    }

    public boolean checkPassword(String p) {
        return p.equals(password);
    }

    public String getUsername() {
        return username;
    }
}
