package lotto.exception;

public enum ErrorCode {
    // 로또 구입 금액 검증 예외 처리
    PURCHASE_AMOUNT_INVALID("[ERROR] 로또 구입 금액은 숫자만 입력할 수 있습니다."),
    PURCHASE_AMOUNT_MIN("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_UNIT("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다."),

    // 당첨 번호 검증 예외 처리
    WINNING_NUMBER_BLANK("[ERROR] 당첨 번호는 공백일 수 없습니다."),
    WINNING_NUMBER_INVALID("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다."),
    WINNING_NUMBER_OUT_OF_RANGE("[ERROR] 당첨 번호는 1과 45 사이여야 합니다."),
    WINNING_NUMBER_SIZE("[ERROR] 당첨 번호는 %d개여야 합니다."),
    WINNING_NUMBER_DUPLICATE("[ERROR] 당첨 번호는 중복될 수 없습니다."),

    // 보너스 번호 검증 예외 처리
    BONUS_NUMBER_BLANK("[ERROR] 보너스 번호는 공백일 수 없습니다."),
    BONUS_NUMBER_INVALID("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR] 보너스 번호는 1과 45 사이여야 합니다."),

    // 로또 번호 검증 예외 처리
    LOTTO_NUMBER_SIZE("[ERROR] 로또 번호는 %d개여야 합니다."),
    LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호는 중복될 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}

