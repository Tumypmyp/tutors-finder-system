package filter;

import user.Tutor;

public class StrategyFilterByAge implements StrategyFilter{
    int from;
    int to;

    public StrategyFilterByAge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean filter(Tutor tutor) {
        return from <= tutor.getAge() && tutor.getAge() <= to;
    }
}
