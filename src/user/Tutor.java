package user;

public class Tutor extends User {
    private int rating;
    private String name;

    public Tutor(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }


}
