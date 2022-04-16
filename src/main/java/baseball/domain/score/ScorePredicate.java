package baseball.domain.score;

import baseball.domain.BaseballNumbers;
import baseball.domain.input.InputNumbers;

public interface ScorePredicate {
    int execute(InputNumbers inputNumbers, BaseballNumbers baseballNumbers);
}
