package baseball.domain.input;

import baseball.domain.input.validator.InputNumbersValidator;
import camp.nextstep.edu.missionutils.Console;

public class RestartInputNumber {
    private final InputNumbersValidator inputNumbersValidator;
    private String input;

    public RestartInputNumber(InputNumbersValidator inputNumbersValidator) {
        this.inputNumbersValidator = inputNumbersValidator;
    }

    public RestartInputNumber receivingRestartInputNumber() {
        input = getUserInput();
        this.inputNumbersValidator.execute(input);
        return this;
    }

    public String getInput() {
        return input;
    }

    private String getUserInput() {
        return Console.readLine();
    }

    public boolean isRestart() {
        return "1".equals(input);
    }
}
