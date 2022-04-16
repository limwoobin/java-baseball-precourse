package baseball.domain.score.impl;

import baseball.domain.BaseballNumbers;
import baseball.game.BaseballGame;
import baseball.domain.input.InputNumbers;
import baseball.domain.score.ScoreFunction;
import java.util.List;

public class BallScoreFunction implements ScoreFunction {
    @Override
    public int execute(InputNumbers inputNumbers, BaseballNumbers baseballNumbers) {
        int count = 0;

        List<Integer> inputNumberList = inputNumbers.getInputNumbers();
        List<Integer> baseballNumberList = baseballNumbers.getBaseballNumber();

        for (int i = 0; i < BaseballGame.BASEBALL_GAME_NUMBER_SIZE; i++) {
            int inputNumber = inputNumberList.get(i);
            int targetNumber = baseballNumberList.get(i);

            count += getBallCount(inputNumber, targetNumber, baseballNumbers);
        }

        return count;
    }

    private int getBallCount(int source, int target, BaseballNumbers baseballNumbers) {
        return baseballNumbers.isContains(source) && isNotStrike(source, target) ? 1 : 0;
    }

    private boolean isNotStrike(int source, int target) {
        return source != target;
    }
}
