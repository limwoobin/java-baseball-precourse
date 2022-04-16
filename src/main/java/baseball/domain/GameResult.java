package baseball.domain;

import baseball.domain.input.InputNumbers;
import baseball.domain.score.ScoreFunction;
import baseball.domain.score.impl.BallScoreFunction;
import baseball.domain.score.impl.StrikeScoreFunction;

public class GameResult {
    private final ScoreFunction strikeScoreFunction;
    private final ScoreFunction ballScoreFunction;
    private int strikeCount;
    private int ballCount;

    public GameResult() {
        this.strikeCount = 0;
        this.ballCount = 0;
        this.strikeScoreFunction = new StrikeScoreFunction();
        this.ballScoreFunction = new BallScoreFunction();
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
