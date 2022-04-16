package baseball;

import baseball.domain.ExceptionType;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1234" , "5678" , "12" , "3" , "345345"})
    void 자리수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionType.INVALID_INPUT_SIZE.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd" , "1w3" , "45t" , "ww " , "32q"})
    void 숫자포맷_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionType.INVALID_INPUT_NUMBER_FORMAT.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"112" , "122" , "344" , "414" , "989"})
    void 중복값_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionType.NOT_CONTAINS_INPUT_OVERLAP.getMessage())
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"120" , "103" , "305" , "502" , "908"})
    void ZERO_포함_예외_테스트(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ExceptionType.NOT_CONTAINS_INPUT_ZERO.getMessage())
        );
    }

    @Test
    void 게임종료_후_완전종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "261", "123", "135", "2");
                    assertThat(output()).contains("낫싱", "1볼 1스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작시_예외() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("123", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ExceptionType.NOT_CONTAINS_RESTART_INPUT_TYPE.getMessage());
                },
                1, 3, 5
        );
    }

    @Test
    void 게임종료_후_재시작시_예외_v2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> run("123", "135", "as2"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ExceptionType.NOT_CONTAINS_RESTART_INPUT_TYPE.getMessage());
                },
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
