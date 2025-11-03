package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.ErrorCode;

public class WinningNumbers {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        List<Integer> numbers = validate(winningNumbers);
        this.winningNumbers = numbers;
    }

    private List<Integer> validate(String winningNumbers) {
        String[] numbersString = winningNumbers.split(",", -1);
        List<Integer> numbers = new ArrayList<>();

        for (String numberString : numbersString) {
            if (numberString == null || numberString.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_BLANK.getMessage());
            }

            int number;
            try {
                number = parseToInt(numberString.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_INVALID.getMessage());
            }

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_OUT_OF_RANGE.getMessage());
            }
            numbers.add(number);
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format(ErrorCode.WINNING_NUMBER_SIZE.getMessage(LOTTO_NUMBER_COUNT))
            );
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorCode.WINNING_NUMBER_DUPLICATE.getMessage());
        }

        return numbers;
    }

    private int parseToInt(String numbers) {
        return Integer.parseInt(numbers);
    }

    public List<Integer> getNumbers() {
        return winningNumbers;
    }
}