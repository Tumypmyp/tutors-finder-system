package user;

public class User {
    private String username;
    private String password;
    protected DataBase db;

    User(String username, String password, DataBase db) {
        this.username = username;
        this.password = password;
        this.db = db;
    }

    public boolean checkPassword(String p) {
        return p.equals(password);
    }

    public String getUsername() {
        return username;
    }
//    protected DataBase getTutors() {return db.;}


}
