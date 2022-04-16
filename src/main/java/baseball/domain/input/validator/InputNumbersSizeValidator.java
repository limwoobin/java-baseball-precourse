package baseball.domain.input.validator;

import baseball.domain.ExceptionType;

public class InputNumbersSizeValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException(ExceptionType.INVALID_INPUT_SIZE.getMessage());
        }
    }
}
