package user;

import database.DataBase;

import java.util.ArrayList;
import java.util.List;

public class Tutor extends User {
    private int rating;
    private String name;
    private int age;
    private Gender gender;

    private List<String> requests = new ArrayList<>();

    public Tutor(String username, String password, DataBase db) {
        super(username, password, db);
        this.name = username;
    }

    public String getName() {
        return name;
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

    public Tutor setName(String name) {
        this.name = name;
        return this;
    }

    public Tutor setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public Tutor setAge(int age) {
        this.age = age;
        return this;
    }

    public Tutor setGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public Tutor addRating(int rate) {
        this.rating += rate;
        return this;
    }
}
