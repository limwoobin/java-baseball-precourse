package baseball.domain.input.validator;

public class InputNumbersSizeValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.length() != 3) {
            throw new IllegalArgumentException("입력한 값은 3자리의 값이어야 합니다.");
        }
    }
}
