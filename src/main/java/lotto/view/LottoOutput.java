package lotto.view;

public class LottoOutput {
    public void printPurchaseAmountInputGuide() {
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printWinningNumbersInputGuide() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printError(String message) {
        System.out.println(message);
    }
}
