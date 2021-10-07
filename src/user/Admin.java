package user;

import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public User addTutor(String username, String password) {
        return db.register(username, password, "Tutor");
    }

    public Book addBook(String name, String author, int yearPublished, int size) {
        Book book = new Book(name, author, yearPublished, size);
        db.books.add(book);
        return book;
    }

    public List<Parent> getParents() {
        return db.getParents();
    }

}
