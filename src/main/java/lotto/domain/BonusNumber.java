package lotto.domain;

import lotto.exception.ErrorCode;
import net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.ErrorSuppressing;

public class BonusNumber {
    private final int bounsNumber;

    public BonusNumber(String bounsNumber) {
        int number = validate(bounsNumber);
        this.bounsNumber = number;
    }

    private int validate(String bounsNumber) {
        if (bounsNumber == null || bounsNumber.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_BLANK.getMessage());
        }

        int number;
        try {
            number = parseToInt(bounsNumber.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_INVALID.getMessage());
        }

        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorCode.BONUS_NUMBER_OUT_OF_RANGE.getMessage());
        }

        return number;
    }

    private int parseToInt(String numbers) {
        return Integer.parseInt(numbers);
    }

    public int getBonusNumber() {
        return bounsNumber;
    }
}
