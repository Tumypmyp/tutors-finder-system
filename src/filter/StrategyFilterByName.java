package filter;

import user.Tutor;

public class StrategyFilterByName implements StrategyFilter {
    private final String name;

    public StrategyFilterByName(String name) {
        this.name = name;
    }

    @Override
    public boolean filter(Tutor tutor) {
        return name.compareToIgnoreCase(tutor.getName()) <= 0 &&
                (name + "zzz").compareToIgnoreCase(tutor.getName()) > 0;
    }
}
