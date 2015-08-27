package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {
    
    private final List<Scoreable> scores = new ArrayList<>();
    
    public void addScoreable(Scoreable scoreable) {
        scores.add(scoreable);
    }
    
    public int arithmeticMean() {
        int total = scores.stream().mapToInt(Scoreable :: getScore).sum();
        return total / scores.size();
    }
}
