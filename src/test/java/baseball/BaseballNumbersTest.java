package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballNumbers;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballNumbersTest {
    private static final int 컴퓨터가_만든_난수_길이 = 3;

    @Test
    @DisplayName("컴퓨터가 만든 난수는 3자리의 숫자이어야 한다")
    void length_test() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();

        assertThat(컴퓨터가_만든_난수_길이).isEqualTo(baseballNumbers.getBaseballNumber().size());
    }

    @Test
    @DisplayName("컴퓨터가 만든 난수는 3자리의 숫자이어야 한다")
    void overlap_test() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> 컴퓨터가_만든_난수 = baseballNumbers.getBaseballNumber();

        Set<Integer> result = new HashSet<>();
        result.addAll(컴퓨터가_만든_난수);

        assertThat(result.size()).isEqualTo(baseballNumbers.getBaseballNumber().size());
    }
}
