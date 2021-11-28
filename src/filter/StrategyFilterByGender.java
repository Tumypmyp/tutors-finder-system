package filter;

import user.Gender;
import user.Tutor;

import java.util.Arrays;
import java.util.List;

public class StrategyFilterByGender implements StrategyFilter {
    public final List<Gender> genders;

    public StrategyFilterByGender(Gender... genders) {
        this.genders = Arrays.asList(genders);
    }

    @Override
    public boolean filter(Tutor tutor) {
        return genders.contains(tutor.getGender());
    }
}
