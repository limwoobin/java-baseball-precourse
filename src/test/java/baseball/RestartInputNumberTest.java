package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import baseball.domain.input.RestartInputNumber;
import baseball.domain.input.validator.InputNumbersRestartValidator;
import baseball.domain.input.validator.InputNumbersValidator;
import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class RestartInputNumberTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("재시작값을 정상적으로 입력하면 입력한값이 정상적으로 리턴되어야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"1" , "2"})
    void restart_input_success_test(String input) {
        InputNumbersValidator validator = new InputNumbersRestartValidator();
        RestartInputNumber restartInputNumber = new RestartInputNumber(validator);

        when(Console.readLine())
                .thenReturn(input);

        restartInputNumber = restartInputNumber.receivingRestartInputNumber();

        assertTrue(input.equals(restartInputNumber.getInput()));
    }

    @DisplayName("재시작값을 1,2 이외의 값을 입력하면 IllegalArgumentException 이 발생시켜야 한다")
    @ParameterizedTest
    @ValueSource(strings = {"0" , "3" , "asd" , "we" , "", "11" , "12"})
    void restart_input_failed_test(String input) {
        InputNumbersValidator validator = new InputNumbersRestartValidator();
        RestartInputNumber restartInputNumber = new RestartInputNumber(validator);

        when(Console.readLine())
                .thenReturn(input);

        assertThatThrownBy(restartInputNumber::receivingRestartInputNumber)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
