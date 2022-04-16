package baseball.domain.input.validator;

import java.util.Arrays;
import java.util.List;

public class InputNumbersValidationCheck {
    private final InputNumbersSizeValidator sizeValidator;
    private final InputNumbersNumberFormatValidator numberFormatValidator;
    private final InputNumbersOverlapValidator overlapValidator;
    private final InputNumbersZeroValidator zeroValidator;
    private final List<InputNumbersValidator> inputNumbersValidators;

    public InputNumbersValidationCheck() {
        this.sizeValidator = new InputNumbersSizeValidator();
        this.numberFormatValidator = new InputNumbersNumberFormatValidator();
        this.overlapValidator = new InputNumbersOverlapValidator();
        this.zeroValidator = new InputNumbersZeroValidator();

        this.inputNumbersValidators = Arrays.asList(
                sizeValidator,
                numberFormatValidator,
                overlapValidator,
                zeroValidator
        );
    }

    public void validate(String inputNumbers) {
        for (InputNumbersValidator validator : this.inputNumbersValidators) {
            validator.execute(inputNumbers);
        }
    }
}
