package filter;

import user.Tutor;

public class StrategyFilterByRating implements StrategyFilter {
    private final int from;
    private final int to;

    public StrategyFilterByRating(int from, int to) {
        this.from = from;
        this.to = to;
    }

    public StrategyFilterByRating() {
        this(0, 100);
    }

    @Override
    public boolean filter(Tutor tutor) {
        return from <= tutor.getRating() && tutor.getRating() <= to;
    }

}
