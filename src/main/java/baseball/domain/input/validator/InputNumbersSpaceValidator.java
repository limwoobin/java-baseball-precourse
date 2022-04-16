package baseball.domain.input.validator;

public class InputNumbersSpaceValidator implements InputNumbersValidator {
    private static final String SPACE = " ";

    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains(SPACE)) {
            throw new IllegalArgumentException("입력한 값에 띄어쓰기가 존재하면 안됩니다.");
        }
    }
}
