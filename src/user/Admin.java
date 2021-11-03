package user;

import java.util.List;

public class Admin extends User {
    public Admin(String username, String password, DataBase db) {
        super(username, password, db);
    }

    public User addTutor(String username, String password) {
        return db.register(username, password, "Tutor");
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
