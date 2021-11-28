package user;

import database.DataBase;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends User {
    private int rating;
    private String name;
    private int age;
    private Gender gender;

    //    private Gender gender;
    private List<String> requests = new ArrayList<>();

    public Tutor(String username, String password, DataBase db) {
        super(username, password, db);
        this.name = username;
    }

    public int getRating() {
        return rating;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
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

    public void setAge(int age) {
        this.age = age;
    }

    public void addRating(int rate) {
        this.rating += rate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
