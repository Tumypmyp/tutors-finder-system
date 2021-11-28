package user;

import book.Readable;
import database.DataBase;
import filter.*;

import java.util.ArrayList;
import java.util.List;

public class Parent extends User {
    StrategyFilter lastStrategyFilter;
    List<Tutor> bookedTutors = new ArrayList<>();

    public Parent(String username, String password, DataBase db) {
        super(username, password, db);
    }

    //
    public List<Tutor> filter() {
        if (lastStrategyFilter == null)
            return new ArrayList<>();
        List<Tutor> tutors = db.getTutors();
        List<Tutor> result = new ArrayList<>();
        for (var t : tutors) {
            if (lastStrategyFilter.filter(t))
                result.add(t);
        }
        return result;

    }

    public void createStrategyFilter(FilterType filterType, String str) {
        lastStrategyFilter = factoryStrategyFilter(filterType, str);
    }

        //    Factory method
    public StrategyFilter factoryStrategyFilter(FilterType filterType, String str) {
        String[] s = str.split("\\s+");
        switch (filterType) {
            case NAME:
                if (s.length == 2)
                    return new StrategyFilterByName(s[1]);
                return new StrategyFilterByName("");
            case RATING:
                if (s.length == 4)
                    return new StrategyFilterByRating(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
                return new StrategyFilterByRating();
            case AGE:
                return new StrategyFilterByAge();
            case GENDER:
                return new StrategyFilterByGender();
            default:
                return null;
        }
    }

    public Readable getBooks() {
        return db.books;
    }

    public void sendRequest(Tutor tutor, String request) {
        tutor.addRequest(request);
    }

    public void rateTutor(Tutor tutor, int rate) {
        tutor.addRating(rate);
    }

    public void bookTutor(Tutor tutor) {
        bookedTutors.add(tutor);
    }


    public void printListOfTutors(List<Tutor> list) {
        for (Tutor tutor : list) {
            System.out.println(tutor.getUsername() + " " + tutor.getRating());
        }
    }
}

