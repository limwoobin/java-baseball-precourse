package baseball.domain.input.validator;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputNumbersOverlapValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        String[] splitInputNumbers = inputNumbers.split("");
        Set<String> set = new HashSet<>(Arrays.asList(splitInputNumbers));

        if (set.size() != 3) {
            throw new IllegalArgumentException("입력한 값은 중복되지 않아야 합니다.");
        }
    }
}
