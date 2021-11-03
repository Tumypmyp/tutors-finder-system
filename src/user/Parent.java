package user;

import book.Readable;
import filter.Filter;
import filter.FilterByName;
import filter.FilterByRating;

import java.util.ArrayList;
import java.util.List;

public class Parent extends User {
    Filter lastFilter;
    List<Tutor> bookedTutors = new ArrayList<>();

    public Parent(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public Filter getLastFilter() {
        return lastFilter;
    }

    public List<Tutor> filter(Filter filter) {
        List<Tutor> tutors = db.getTutors();
        lastFilter = filter;
        return filter.getTutors(tutors);
    }

//    Factory method
    public Filter createFilter(String str) {
        String[] s = str.split("\\s+");
        if (s[0].equals("ByName")) {
            if (s.length == 2)
                return new FilterByName(s[1]);
            return new FilterByName("");
        } else if (s[0].equals("ByRating")) {
            if (s.length == 4)
                return new FilterByRating(Integer.parseInt(s[1]), Integer.parseInt(s[2]), Boolean.parseBoolean(s[3]));
            return new FilterByRating();
        }

        return null;
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

