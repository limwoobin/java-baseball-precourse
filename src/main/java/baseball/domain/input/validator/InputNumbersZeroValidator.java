package baseball.domain.input.validator;

public class InputNumbersZeroValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains("0")) {
            throw new IllegalArgumentException();
        }
    }
}
