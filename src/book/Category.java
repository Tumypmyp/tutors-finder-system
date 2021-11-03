package book;

import java.util.ArrayList;
import java.util.List;

// COMPOSITE pattern: Composite
public class Category implements Readable {
    private String name;
    private List<Readable> content = new ArrayList<>();

    public Category(String name, List<Readable> content) {
        this.name = name;
        this.content.addAll(content);
    }

    public String read() {
        StringBuilder result = new StringBuilder();
        for (Readable r : content) {
            result.append(r.read()).append(",\n");
        }
        return "(" + name + ":\n" + result.toString() + ")";
    }
}
