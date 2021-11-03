package filter;

import user.Tutor;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByName implements Filter {
    private final String name;

    public FilterByName(String name) {
        this.name = name;
    }

    @Override
    public List<Tutor> getTutors(List<Tutor> tutors) {
        Predicate<Tutor> byName = tutor -> name.compareToIgnoreCase(tutor.getUsername()) <= 0
                && (name + "zzz").compareToIgnoreCase(tutor.getUsername()) > 0;
        List<Tutor> result = tutors.stream().filter(byName)
                .sorted(Comparator.comparing(Tutor::getUsername))
                .collect(Collectors.toList());
        return result;
    }
}
