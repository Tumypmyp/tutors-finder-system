package filter;

import user.Tutor;

import java.util.List;

public interface Filter {
    List<Tutor> getTutors(List<Tutor> tutors);
}
