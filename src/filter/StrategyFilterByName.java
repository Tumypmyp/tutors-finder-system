package filter;

import user.Tutor;

public class StrategyFilterByName implements StrategyFilter {
    private final String name;

    public StrategyFilterByName(String name) {
        this.name = name.toLowerCase();
    }

    public StrategyFilterByName() {
        this("");
    }

    @Override
    public boolean filter(Tutor tutor) {
        return tutor.getName().toLowerCase().contains(name);
    }
}
