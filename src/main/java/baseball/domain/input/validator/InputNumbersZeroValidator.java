package baseball.domain.input.validator;

import baseball.domain.ExceptionType;

public class InputNumbersZeroValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains("0")) {
            throw new IllegalArgumentException(ExceptionType.NOT_CONTAINS_INPUT_ZERO.getMessage());
        }
    }
}
