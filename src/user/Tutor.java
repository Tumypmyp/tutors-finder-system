package user;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends User {
    private int rating;
    private String name;
    private List<String> requests = new ArrayList<>();

    public Tutor(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public int getRating() {
        return rating;
    }

    public void addRequest(String request) {
        requests.add(request);
    }

    public List<String> getRequests() {
        return requests;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addRating(int rate) {
        rating += rate;
    }


}
