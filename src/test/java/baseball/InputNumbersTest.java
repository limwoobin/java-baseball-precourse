package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import baseball.domain.input.InputNumbers;
import baseball.domain.input.validator.InputNumbersNumberFormatValidator;
import baseball.domain.input.validator.InputNumbersOverlapValidator;
import baseball.domain.input.validator.InputNumbersSizeValidator;
import baseball.domain.input.validator.InputNumbersSpaceValidator;
import baseball.domain.input.validator.InputNumbersValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class InputNumbersTest {
    @Nested
    @DisplayName("사용자의 입력값이 올바른지 검증하라")
    class UserInputValidTest {

        @DisplayName("사용자가 입력한 숫자가 3자리의 수가 아니라면 IllegalArgumentException 을 발생시켜야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"1234" , "12" , "12345" , "1 3 5"})
        void input_size_test(String input) {
            InputNumbersValidator validator = new InputNumbersSizeValidator();

            assertThatThrownBy(() -> {
                validator.execute(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자가 입력한 값이 숫자형식이 아니라면 IllegalArgumentException 을 발생시켜야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"1a3dg" , "wqwed" , "" , "          " , "1,2,3" , "1 3 5"})
        void input_number_format_test(String input) {
            InputNumbersValidator validator = new InputNumbersNumberFormatValidator();

            assertThatThrownBy(() -> {
                validator.execute(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자가 입력한 숫자가 중복을 포함하고 있다면 IllegalArgumentException 을 발생시켜야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"221" , "133" , "533" , "555" , "288" , "882"})
        void input_overlap_test(String input) {
            InputNumbersValidator validator = new InputNumbersOverlapValidator();

            assertThatThrownBy(() -> {
                validator.execute(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("사용자가 입력한 값에 빈칸이 포함되어 있다면 IllegalArgumentException 을 발생시켜야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"1 3 5" , "1 2 3" , "12 3", "1          23"})
        void input_space_test(String input) {
            InputNumbersValidator validator = new InputNumbersSpaceValidator();

            assertThatThrownBy(() -> {
                validator.execute(input);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    @DisplayName("입력값이 정상적이라면 정상적인 List<Integer> 의 형태로 리턴되어야 한다")
    class UserInputSuccessTest {
        private MockedStatic<Console> console;

        @BeforeEach
        void before() {
            console = mockStatic(Console.class);
        }

        @AfterEach
        void after() {
            console.close();
        }

        @DisplayName("입력값이 정상적인 값이라면 List 형태로 리턴되어야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"123" , "134" , "145" , "456"})
        void input_success_test(String input) {
            InputNumbers inputNumbers = new InputNumbers();

            when(Console.readLine())
                    .thenReturn(input);

            List<Integer> result = inputNumbers.createInputNumbers();
            String[] inputValues = input.split("");

            assertThat(result.get(0)).isEqualTo(Integer.parseInt(inputValues[0]));
            assertThat(result.get(1)).isEqualTo(Integer.parseInt(inputValues[1]));
            assertThat(result.get(2)).isEqualTo(Integer.parseInt(inputValues[2]));
        }
    }

    @Nested
    @DisplayName("입력값이 올바르지 않다면 IllegalArgumentException 을 발생시켜야 한다")
    class UserInputFailedTest {
        private MockedStatic<Console> console;

        @BeforeEach
        void before() {
            console = mockStatic(Console.class);
        }

        @AfterEach
        void after() {
            console.close();
        }

        @DisplayName("입력값이 올바르지 않다면 IllegalArgumentException 을 발생시켜야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"1 34" , "112" , "12343" , "qwdewe" , "1w3"})
        void input_failed_test(String input) {
            InputNumbers inputNumbers = new InputNumbers();

            when(Console.readLine())
                    .thenReturn(input);

            assertThatThrownBy(inputNumbers::createInputNumbers).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
