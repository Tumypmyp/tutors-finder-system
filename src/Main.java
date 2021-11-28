import database.DataBase;
import filter.FilterType;
import user.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Creating database
        DataBase db = new DataBase();

//        Adding admin
        Admin admin = (Admin) db.register("administrator", "987654321", UserType.ADMIN);

//        Admin can add Tutors
        admin.addTutor("mishanya2000", "11111111").setRating(6);
        admin.addTutor("alex228", "12345678").setName("Alexander").setRating(9).setAge(25).setGender(Gender.MALE);
        admin.addTutor("bob1337", "12345678").setName("Bob").setRating(7).setAge(21).setGender(Gender.INTERSEX);
        admin.addTutor("bbborisss", "12345678").setName("Boris Ivanovich").setRating(4).setAge(30).setGender(Gender.TRANS);
        admin.addTutor("romadoma", "12345678").setName("Roman").setRating(5).setGender(Gender.TRANS).setAge(27);

//        Tutors are added by a FACTORY method - register
        Tutor tutor = (Tutor) db.register("vanyusha", "12345678", UserType.TUTOR);
        tutor.setName("Vanya").setRating(6).addRating(3).setAge(22).setGender(Gender.FEMALE);

//        Parents are added by the same FACTORY method - register
        Parent par = (Parent) db.register("sonya", "12345678", UserType.PARENT);


        System.out.println("\n\tTesting StrategyFilterByAge: default from 0 to 100:");
        par.setStrategyFilter(FilterType.AGE);
        List<Tutor> res = par.filter();
        par.printListOfTutors(res);

        System.out.println("\n\tTesting StrategyFilterByRating: from 5 to 7");
        par.setStrategyFilter(FilterType.RATING, 5, 7);
        par.printListOfTutors(par.filter());

        System.out.println("\n\tTesting StrategyFilterByName: starts with \"bo\"");
        par.setStrategyFilter(FilterType.NAME, "bo");
        par.printListOfTutors(par.filter());

        System.out.println("\n\tTesting StrategyFilterByGender: trans or female");
        par.setStrategyFilter(FilterType.GENDER, Gender.TRANS, Gender.FEMALE);
        par.printListOfTutors(par.filter());

        return;
        /*/
//        filtering tutors by rating using FACTORY method
        System.out.println("\n\tTesting StrategyFilterByRating using FACTORY method (default from 0 to 100):");
        par.setStrategyFilter(FilterType.RATING);
        par.printListOfTutors(par.filter());

        System.out.println("\n\tTesting StrategyFilterByRating - from 5 to 8:");
        par.setStrategyFilter(FilterType.RATING, 5, 8);
        par.printListOfTutors(par.filter());

//        filtering tutors by name using FACTORY method
        System.out.println("\n\tTesting StrategyFilterByName - default all:");
        par.setStrategyFilter(FilterType.NAME);
        par.printListOfTutors(par.filter());

        System.out.println("\n\tTesting StrategyFilterByName - with beginning \"bo\":");
        par.setStrategyFilter(FilterType.NAME, "bo");
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
        System.out.println("\n\tTesting get all books function with COMPOSITE pattern:");
        System.out.println(par.getBooks().read());

//        printing books from a category
        System.out.println("\n\tTesting get books from a category function:");
        System.out.println(SSADCategory.read());
//        end of COMPOSITE pattern testing


//        testing parents functionality
        List<Parent> parents = admin.getParents();
        par = parents.get(0);
//        find, book and rate tutor functions
        par.setStrategyFilter(FilterType.NAME, "bob");
        Tutor tut = par.filter().get(0);

        System.out.println("\n\tTesting booking a tutor:");
        par.sendRequest(tut, "can i have a lesson at 5 pm today?");
        System.out.println(tut.getRequests().get(0) + " - received requests");

        System.out.println("\n\tTesting rateTutor bob:");
        par.bookTutor(tut);
        par.rateTutor(tut, 50);
//        updated rating
        par.printListOfTutors(par.filter());

         //*/
    }
}
