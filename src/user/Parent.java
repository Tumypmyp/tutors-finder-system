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

    public void setStrategyFilter(FilterType filterType, Object... args) {
        lastStrategyFilter = createStrategyFilter(filterType, args);
    }

    //    Factory method
    public StrategyFilter createStrategyFilter(FilterType filterType, Object... args) {
        switch (filterType) {
            case NAME:
                if (0 < args.length)
                    return new StrategyFilterByName((String) args[0]);
                return new StrategyFilterByName();
            case RATING:
                if (1 < args.length)
                    return new StrategyFilterByRating((int) args[0], (int) args[1]);
                return new StrategyFilterByRating();
            case AGE:
                if (1 < args.length)
                    return new StrategyFilterByAge((int) args[0], (int) args[1]);
                return new StrategyFilterByAge();
            case GENDER:
                return new StrategyFilterByGender((Gender[]) args);
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

