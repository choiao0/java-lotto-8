package lotto.view;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class LottoOutput {
    public void printPurchaseAmountInputGuide() {
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printQuantity(int quantity) {
        System.out.println();
        System.out.println(quantity + "개를 구매했습니다.");
    }

    public void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]")));
        }
    }

    public void printWinningNumbersInputGuide() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberInputGuide() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printStatistics(List<String> lines) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
