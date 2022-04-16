package baseball.domain;

public enum ExceptionType {
    INVALID_INPUT_SIZE("입력한 값은 3자리의 값이어야 합니다."),
    INVALID_INPUT_NUMBER_FORMAT("입력한 값은 숫자형식의 값이어야 합니다."),
    NOT_CONTAINS_INPUT_OVERLAP("입력한 값은 중복되지 않아야 합니다."),
    NOT_CONTAINS_RESTART_INPUT_TYPE("입력한 값은 1 또는 2이어야 합니다."),
    NOT_CONTAINS_INPUT_SPACE("입력한 값에 띄어쓰기가 존재하면 안됩니다."),
    NOT_CONTAINS_INPUT_ZERO("입력한 값에 0이 포함될 수 없습니다.");

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
