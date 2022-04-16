package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.LinkedHashSet;
import java.util.Set;

public class BaseballNumbers {
    private final Set<String> baseballNumber;

    public BaseballNumbers() {
        this.baseballNumber = new LinkedHashSet<>();
    }

    public Set<String> createBaseballNumber() {
        while (this.baseballNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            this.baseballNumber.add(String.valueOf(randomNumber));
        }

        return this.baseballNumber;
    }
}
