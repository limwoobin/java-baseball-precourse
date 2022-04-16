package baseball.domain.input.validator;

import baseball.domain.ExceptionType;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputNumbersOverlapValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        String[] splitInputNumbers = inputNumbers.split("");
        Set<String> set = new HashSet<>(Arrays.asList(splitInputNumbers));

        if (set.size() != 3) {
            throw new IllegalArgumentException(ExceptionType.NOT_CONTAINS_INPUT_OVERLAP.getMessage());
        }
    }
}
