import user.DataBase;
import user.Parent;
import user.Tutor;
import user.filter.FilterByRating;

public class Main {

    public static void main(String[] args) {
        DataBase db = new DataBase();
        ((Tutor)db.register("Alex", "12345678", "Tutor")).setRating(9);
        ((Tutor)db.register("Roma", "12345678", "Tutor")).setRating(2);
        ((Tutor)db.register("Vova", "12345678", "Tutor")).setRating(6);

        Parent par = (Parent) db.register("Sonya", "12345678", "Parent");

        System.out.println("\n\tTesting filterByRating:");
        var res = par.filter(new FilterByRating());
        for (Tutor tutor : res) {
            System.out.println(tutor.getUsername() + " " + tutor.getRating());
        }

    }
}
