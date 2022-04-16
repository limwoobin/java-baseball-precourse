package baseball.domain.input.validator;

import baseball.domain.ExceptionType;

public class InputNumbersRestartValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (!("1".equals(inputNumbers) || "2".equals(inputNumbers))) {
            throw new IllegalArgumentException(ExceptionType.NOT_CONTAINS_RESTART_INPUT_TYPE.getMessage());
        }
    }
}
