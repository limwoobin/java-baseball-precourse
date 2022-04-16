package baseball.domain.input.validator;

import baseball.domain.ExceptionType;

public class InputNumbersNumberFormatValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionType.INVALID_INPUT_NUMBER_FORMAT.getMessage());
        }
    }
}
