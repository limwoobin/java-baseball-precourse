package baseball.domain.input.validator;

public class InputNumbersZeroValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        if (inputNumbers.contains("0")) {
            throw new IllegalArgumentException("입력한 값에 0이 포함될 수 없습니다.");
        }
    }
}
