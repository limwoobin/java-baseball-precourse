package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private final List<Integer> baseballNumber;

    public BaseballNumbers() {
        this.baseballNumber = new ArrayList<>();
    }

    public List<Integer> createBaseballNumber() {
        while (this.baseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            this.baseballNumber.add(randomNumber);
        }

        return this.baseballNumber;
    }
}
