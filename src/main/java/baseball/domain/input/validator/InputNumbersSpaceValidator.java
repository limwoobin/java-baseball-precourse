package baseball.domain.input.validator;

public class InputNumbersSpaceValidator implements InputNumbersValidator {
    private static final String SPACE = " ";

    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }
}
