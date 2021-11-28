import book.Book;
import book.Category;
import database.DataBase;
import filter.FilterType;
import filter.StrategyFilter;
import user.Admin;
import user.Parent;
import user.Tutor;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        creating database
        DataBase db = new DataBase();

//        adding admin
        Admin admin = (Admin) db.register("administrator", "987654321", "Admin");
        admin.addTutor("Misha", "11111111");

//        adding Tutors
        admin.addTutor("Alex", "12345678").setRating(9);
        admin.addTutor("Bob", "12345678").setRating(7);
        admin.addTutor("Boris", "12345678").setRating(4);
        admin.addTutor("Roma", "12345678").setRating(5);


//        adding a tutor using FACTORY method
        Tutor tutor = (Tutor) db.register("Vova", "12345678", "Tutor");
        tutor.setRating(6);
//        adding a parent using FACTORY method
        Parent par = (Parent) db.register("Sonya", "12345678", "Parent");

//        filtering tutors by rating using FACTORY method
        System.out.println("\n\tTesting filterByRating using FACTORY method (default from 0 to 100):");
        par.createStrategyFilter(FilterType.RATING, "ByRating");
        List<Tutor> res = par.filter();
        par.printListOfTutors(res);

        System.out.println("\n\tTesting filterByRating - from 5 to 8:");
        par.createStrategyFilter(FilterType.RATING, "ByRating 5 8 true");
        par.printListOfTutors(par.filter());

//        filtering tutors by name using FACTORY method
        System.out.println("\n\tTesting filterByName - default all:");
        par.createStrategyFilter(FilterType.NAME, "ByName");
        par.printListOfTutors(par.filter());

        System.out.println("\n\tTesting filterByName - with beginning \"bo\":");
        par.createStrategyFilter(FilterType.NAME, "ByName bo");
        par.printListOfTutors(par.filter());
//


//        testing of added COMPOSITE pattern
//        making books and categories
        Book book1 = admin.makeBook("The History of Science", "Merlin H.", 2013, 300);
        Book book2 = admin.makeBook("Design Patterns", "Erich Gamma", 1994, 395);
        Book book3 = admin.makeBook("Design Patterns (Java)", "Erich Gamma", 2003, 455);
        Category SSADCategory = admin.makeCategory("SSAD", Arrays.asList(book2, book3));
        Book book4 = admin.makeBook("book1", "author1", 2000, 200);
        db.books = new Category("all books", Arrays.asList(book1, SSADCategory, book4));

//        printing all books
        System.out.println("\n\tTesting get all books function with COMPOSITE pattern:\n");
        System.out.println(db.books.read());

//        printing books from a category
        System.out.println("\n\tTesting get books from a category function:\n");
        System.out.println(SSADCategory.read());
//        end of COMPOSITE pattern testing


//        testing parents functionality
        List<Parent> parents = admin.getParents();
        par = parents.get(0);
//        find, book and rate tutor functions
        par.createStrategyFilter(FilterType.NAME, "ByName bob");
        Tutor tut = par.filter().get(0);

        System.out.println("\n\tTesting booking a tutor:");
        par.sendRequest(tut, "can i have a lesson at 5 pm today?");
        System.out.println(tut.getRequests().get(0) + " - received requests");

        System.out.println("\n\tTesting rateTutor bob:");
        par.bookTutor(tut);
        par.rateTutor(tut, 50);
//        updated rating
        par.printListOfTutors(par.filter());
    }
}
