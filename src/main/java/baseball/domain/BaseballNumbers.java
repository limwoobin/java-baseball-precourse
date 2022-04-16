package baseball.domain;

import baseball.game.BaseballGame;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private List<Integer> baseballNumber;

    public BaseballNumbers() {
        this.baseballNumber = new ArrayList<>();
        this.baseballNumber = createBaseballNumber();
    }

    private List<Integer> createBaseballNumber() {
        while (this.baseballNumber.size() < BaseballGame.BASEBALL_GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            overlapCheckAndAdd(randomNumber);
        }

        return this.baseballNumber;
    }

    private void overlapCheckAndAdd(int number) {
        if (!isContains(number)) {
            this.baseballNumber.add(number);
        }
    }

    public List<Integer> getBaseballNumber() {
        return baseballNumber;
    }

    public boolean isContains(int number) {
        return this.baseballNumber.contains(number);
    }
}
