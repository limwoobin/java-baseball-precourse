package baseball.domain.input.validator;

public class InputNumbersNumberFormatValidator implements InputNumbersValidator {
    @Override
    public void execute(String inputNumbers) {
        try {
            Integer.parseInt(inputNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값은 숫자형식의 값이어야 합니다.");
        }
    }
}
