package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PurchaseAmountTest {
    @Test
    void 구입_금액이_유효하면_정상적으로_생성된다() {
        PurchaseAmount purchaseAmount = new PurchaseAmount("3000");
        assertEquals(3000, purchaseAmount.getPurchaseAmount());
    }

    @Test
    void 구입_금액에_숫자_외의_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("1,000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 숫자만 입력할 수 있습니다.");
    }

    @Test
    void 구입_금액이_1000_미만이면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("100"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 이상이어야 합니다.");
    }

    @Test
    void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외가_발생한다() {
        assertThatThrownBy(() -> new PurchaseAmount("2500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.");
    }
}