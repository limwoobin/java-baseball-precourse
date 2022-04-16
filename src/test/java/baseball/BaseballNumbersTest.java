package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballNumbers;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumbersTest {
    private static final int 컴퓨터가_만든_난수_길이 = 3;

    @Test
    @DisplayName("컴퓨터가 만든 난수는 3자리의 숫자이며, 중복이 없는 숫자여야 한다")
    void length_test() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> baseballNumber = baseballNumbers.createBaseballNumber();

        assertThat(컴퓨터가_만든_난수_길이).isEqualTo(baseballNumber.size());
    }
}
