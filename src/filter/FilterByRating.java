package filter;

import user.Tutor;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByRating implements Filter {
    private final int from;
    private final int to;
    private final boolean incr;

    public FilterByRating() {
        this(0, 100, true);
    }

    public FilterByRating(int from, int to, boolean incr) {
        this.from = from;
        this.to = to;
        this.incr = incr;
    }

    @Override
    public List<Tutor> getTutors(List<Tutor> tutors) {
        Predicate<Tutor> byRating = tutor -> from <= tutor.getRating() && tutor.getRating() <= to;
        List<Tutor> result = tutors.stream().filter(byRating)
                .sorted(Comparator.comparing(Tutor::getRating))
                .collect(Collectors.toList());
        return result;
    }

}
