package baseball.domain.input;

import baseball.domain.input.validator.InputNumbersValidationCheck;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputNumbers {
    private List<Integer> inputNumbers;
    private InputNumbersValidationCheck validationCheck;

    public InputNumbers() {
        inputNumbers = new ArrayList<>();
        validationCheck = new InputNumbersValidationCheck();
    }

    public InputNumbers receiveInputNumbers() {
        String inputValue = getUserInput();
        validationCheck.validate(inputValue);
        this.inputNumbers = stringToIntegerList(inputValue);
        return this;
    }

    public List<Integer> getInputNumbers() {
        return inputNumbers;
    }

    public String getUserInput() {
        return Console.readLine();
    }

    private List<Integer> stringToIntegerList(String inputValue) {
        String[] splitInputValue = inputValue.split("");
        for (String value : splitInputValue) {
            this.inputNumbers.add(Integer.parseInt(value));
        }

        return inputNumbers;
    }
}
