package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.LottoQuantity;
import lotto.domain.Lottos;
import lotto.domain.PurchaseAmount;
import lotto.domain.WinningNumbers;
import lotto.view.LottoInput;
import lotto.view.LottoOutput;

public class LottoController {
    private final LottoInput lottoInput;
    private final LottoOutput lottoOutput;

    public LottoController(LottoInput lottoInput, LottoOutput lottoOutput) {
        this.lottoInput = lottoInput;
        this.lottoOutput = lottoOutput;
    }

    public void run() {
        PurchaseAmount purchaseAmount = null;
        while (purchaseAmount == null) {
            try {
                lottoOutput.printPurchaseAmountInputGuide();
                String amount = lottoInput.inputPurchaseAmount();
                purchaseAmount = new PurchaseAmount(amount);
            } catch (IllegalArgumentException e) {
                lottoOutput.printError(e.getMessage());
            }
        }
        LottoQuantity lottoQuantity = LottoQuantity.from(purchaseAmount);
        int quantity = lottoQuantity.getQuantity();
        lottoOutput.printQuantity(quantity);

        Lottos lottos = Lottos.generateLottos(quantity);
        lottoOutput.printLottoNumbers(lottos.getLottos());

        WinningNumbers winningNumbers = null;
        while (winningNumbers == null) {
            try {
                lottoOutput.printWinningNumbersInputGuide();
                String numbers = lottoInput.inputWinningNumbers();
                winningNumbers = new WinningNumbers(numbers);
            } catch (IllegalArgumentException e) {
                lottoOutput.printError(e.getMessage());
            }
        }

        BonusNumber bonusNumber = null;
        while (bonusNumber == null) {
            try {
                lottoOutput.printBonusNumberInputGuide();
                String number = lottoInput.inputBonusNumber();
                bonusNumber = new BonusNumber(number);
            } catch (IllegalArgumentException e) {
                lottoOutput.printError(e.getMessage());
            }
        }
    }
}
