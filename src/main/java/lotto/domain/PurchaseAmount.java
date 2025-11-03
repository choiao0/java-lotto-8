package lotto.domain;

import lotto.exception.ErrorCode;

public class PurchaseAmount {
    private static final int LOTTO_PRICE_UNIT = 1000;

    private final int purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = parseToInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        if (purchaseAmount == null || !purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_INVALID.getMessage());
        }
        int amount = parseToInt(purchaseAmount);
        if (amount < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_MIN.getMessage());
        }
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException(ErrorCode.PURCHASE_AMOUNT_UNIT.getMessage());
        }
    }

    private int parseToInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
