package user;

import book.Book;
import book.Category;
import book.Readable;

import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public Tutor addTutor(String username, String password) {
        return (Tutor)db.register(username, password, "Tutor");
    }

    public Book makeBook(String name, String author, int yearPublished, int size) {
        return new Book(name, author, yearPublished, size);
    }

    public Category makeCategory(String name, List<Readable> c) {
        return new Category(name, c);

    }

    public List<Parent> getParents() {
        return db.getParents();
    }

}
