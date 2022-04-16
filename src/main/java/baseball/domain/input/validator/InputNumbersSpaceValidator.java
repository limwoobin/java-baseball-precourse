package baseball.domain.input.validator;

import baseball.domain.ExceptionType;

public class InputNumbersSpaceValidator implements InputNumbersValidator {
    private static final String SPACE = " ";

    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains(SPACE)) {
            throw new IllegalArgumentException(ExceptionType.NOT_CONTAINS_INPUT_SPACE.getMessage());
        }
    }
}
