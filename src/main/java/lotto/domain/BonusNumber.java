package lotto.domain;

public class BonusNumber {
    private final int bounsNumber;

    public BonusNumber(String bounsNumber) {
        int number = validate(bounsNumber);
        this.bounsNumber = number;
    }

    private int validate(String bounsNumber) {
        if (bounsNumber == null || bounsNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 공백일 수 없습니다.");
        }

        int number;
        try {
            number = parseToInt(bounsNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
        }

        return number;
    }

    private int parseToInt(String numbers) {
        return Integer.parseInt(numbers);
    }
}
