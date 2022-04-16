package baseball.domain.score;

import baseball.domain.BaseballNumbers;
import baseball.domain.input.InputNumbers;

public interface ScoreFunction {
    int execute(InputNumbers inputNumbers, BaseballNumbers baseballNumbers);
}
