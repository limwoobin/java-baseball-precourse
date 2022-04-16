package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import baseball.domain.BaseballNumbers;
import baseball.domain.input.InputNumbers;
import baseball.domain.score.ScorePredicate;
import baseball.domain.score.impl.StrikeScorePredicate;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;

public class BaseballScoreTest {

    @Nested
    @DisplayName("사용자가 공을 던졌을때 스트라이크가 몇개인지 리턴하라")
    class StrikeTest {
        private MockedStatic<Console> console;

        @BeforeEach
        void before() {
            console = mockStatic(Console.class);
        }

        @AfterEach
        void after() {
            console.close();
        }

        @DisplayName("스트라이크가 1인 값을 입력하면 스트라이크값이 1로 계산되서 리턴되어야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"124", "153" , "245" , "234"})
        void one_strike_test(String input) {
            BaseballNumbers baseballNumbers = mock(BaseballNumbers.class);
            InputNumbers inputNumbers = new InputNumbers();
            ScorePredicate scorePredicate = new StrikeScorePredicate();


            when(baseballNumbers.getBaseballNumber())
                    .thenReturn(Arrays.asList(1,3,5));
            when(Console.readLine())
                    .thenReturn(input);

            inputNumbers.createInputNumbers();
            int result = scorePredicate.execute(inputNumbers, baseballNumbers);
            assertEquals(1, result);
        }

        @DisplayName("스트라이크가 2인 값을 입력하면 스트라이크값이 2로 계산되서 리턴되어야 한다")
        @ParameterizedTest
        @ValueSource(strings = {"134", "125" , "138" , "235"})
        void two_strike_test(String input) {
            BaseballNumbers baseballNumbers = mock(BaseballNumbers.class);
            InputNumbers inputNumbers = new InputNumbers();
            ScorePredicate scorePredicate = new StrikeScorePredicate();


            when(baseballNumbers.getBaseballNumber())
                    .thenReturn(Arrays.asList(1,3,5));
            when(Console.readLine())
                    .thenReturn(input);

            inputNumbers.createInputNumbers();
            int result = scorePredicate.execute(inputNumbers, baseballNumbers);
            assertEquals(2, result);
        }

        @DisplayName("스트라이크가 3인 값을 입력하면 스트라이크값이 3로 계산되서 리턴되어야 한다")
        @Test
        void three_strike_test() {
            BaseballNumbers baseballNumbers = mock(BaseballNumbers.class);
            InputNumbers inputNumbers = new InputNumbers();
            ScorePredicate scorePredicate = new StrikeScorePredicate();
            String input = "135";

            when(baseballNumbers.getBaseballNumber())
                    .thenReturn(Arrays.asList(1,3,5));
            when(Console.readLine())
                    .thenReturn(input);

            inputNumbers.createInputNumbers();
            int result = scorePredicate.execute(inputNumbers, baseballNumbers);
            assertEquals(3, result);
        }
    }
}
