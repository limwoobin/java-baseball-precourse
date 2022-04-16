package baseball.domain;

import baseball.domain.input.InputNumbers;
import baseball.domain.score.ScoreFunction;
import baseball.domain.score.impl.BallScoreFunction;
import baseball.domain.score.impl.StrikeScoreFunction;

public class GameResult {
    private final ScoreFunction strikeScoreFunction;
    private final ScoreFunction ballScoreFunction;
    private int strikeCount;
    private int outCount;

    public GameResult() {
        this.strikeCount = 0;
        this.outCount = 0;
        this.strikeScoreFunction = new StrikeScoreFunction();
        this.ballScoreFunction = new BallScoreFunction();
    }

    public void strike() {
        this.strikeCount++;
    }

    public void out() {
        this.outCount++;
    }

    public boolean isGameOver() {
        return strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getOutCount() {
        return outCount;
    }

    public boolean isNothing() {
        return strikeCount == 0 && outCount == 0;
    }

    public void calculateScore(InputNumbers inputNumbers, BaseballNumbers baseballNumbers) {
        this.clear();
        this.strikeCount = strikeScoreFunction.execute(inputNumbers, baseballNumbers);
        this.outCount = ballScoreFunction.execute(inputNumbers, baseballNumbers);
    }

    private void clear() {
        this.strikeCount = 0;
        this.outCount = 0;
    }
}
