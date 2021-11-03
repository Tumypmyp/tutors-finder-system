package user.book;

public class Book implements Readable {
    public String name;
    public String author;
    public int yearPublished;
    public int size;

    public Book(String name, String author, int yearPublished, int size) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
        this.size = size;
    }

    public String read() {
        return name + " " + author;
    }

}
