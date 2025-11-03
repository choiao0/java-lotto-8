package lotto.domain;

public class LottoQuantity {
    private static final int LOTTO_PRICE_UNIT = 1000;

    private final int quantity;

    private LottoQuantity(int quantity) {
        this.quantity = quantity;
    }

    public static LottoQuantity from(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.getPurchaseAmount() / LOTTO_PRICE_UNIT;
        return new LottoQuantity(count);
    }

    public int getQuantity() {
        return quantity;
    }
}