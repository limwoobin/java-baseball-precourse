package baseball.domain.input.validator;

public class InputNumbersNumberFormatValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
