package baseball.domain;

import baseball.domain.input.InputNumbers;
import baseball.domain.score.ScoreFunction;

public class GameResult {
    private final ScoreFunction strikeScoreFunction;
    private final ScoreFunction ballScoreFunction;
    private int strikeCount;
    private int ballCount;

    public GameResult(ScoreFunction strikeScoreFunction, ScoreFunction ballScoreFunction) {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.strikeScoreFunction = strikeScoreFunction;
        this.ballScoreFunction = ballScoreFunction;
    }

    public boolean isGameOver() {
        return strikeCount == 3;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public boolean isNothing() {
        return strikeCount == 0 && ballCount == 0;
    }

    public void calculateScore(InputNumbers inputNumbers, BaseballNumbers baseballNumbers) {
        this.clear();
        this.strikeCount = strikeScoreFunction.execute(inputNumbers, baseballNumbers);
        this.ballCount = ballScoreFunction.execute(inputNumbers, baseballNumbers);
    }

    private void clear() {
        this.strikeCount = 0;
        this.ballCount = 0;
    }
}
