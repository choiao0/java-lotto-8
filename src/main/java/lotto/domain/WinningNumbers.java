package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백일 수 없습니다.");
            }

            int number;
            try {
                number = parseToInt(numberString.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
            }

            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
            }
            numbers.add(number);
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 당첨 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT)
            );
        }

        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
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