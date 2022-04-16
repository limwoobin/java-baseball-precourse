package baseball.domain.input.validator;

public class InputNumbersSizeValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
}
