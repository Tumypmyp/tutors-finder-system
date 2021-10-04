package user;

import user.filter.Filter;
import user.filter.FilterByRating;

import java.util.List;

public class Parent extends User{
    Filter lastFilter;
    public Parent(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public Filter getLastFilter() {
        return lastFilter;
    }

    public List<Tutor> filter(Filter filter) {
        List<Tutor> tutors = db.getTutors();
        return filter.getTutors(tutors);
    }

    public Filter createFilter(String s) {
        return new FilterByRating();
    }


}

