package lotto.domain;

public class PurchaseAmount {
    private static final int LOTTO_PRICE_UNIT = 1000;

    private final int purchaseAmount;

    public PurchaseAmount(String purchaseAmount) {
        validate(purchaseAmount);
        this.purchaseAmount = parseToInt(purchaseAmount);
    }

    private void validate(String purchaseAmount) {
        if (purchaseAmount == null || !purchaseAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력할 수 있습니다.");
        }
        int amount = parseToInt(purchaseAmount);
        if (amount < LOTTO_PRICE_UNIT) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
        }
        if (amount % LOTTO_PRICE_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    private int parseToInt(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount);
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
