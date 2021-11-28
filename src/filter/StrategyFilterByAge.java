package filter;

import user.Tutor;

public class StrategyFilterByAge implements StrategyFilter {
    private final int from;
    private final int to;

    public StrategyFilterByAge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public StrategyFilterByAge() {
        this(0, 100);
    }

    @Override
    public boolean filter(Tutor tutor) {
        return from <= tutor.getAge() && tutor.getAge() <= to;
    }
}
