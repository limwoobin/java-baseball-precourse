package baseball.domain.input.validator;

public class InputNumbersRestartValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (!("1".equals(inputNumbers) || "2".equals(inputNumbers))) {
            throw new IllegalArgumentException();
        }
    }
}
