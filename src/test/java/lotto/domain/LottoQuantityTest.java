package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LottoQuantityTest {
    @Test
    void 구입_금액이_유효하면_수량이_정상적으로_계산된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        LottoQuantity quantity = LottoQuantity.from(purchaseAmount);

        assertEquals(3, quantity.getQuantity());
    }
}
