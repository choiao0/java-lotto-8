package lotto.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class LottosTest {
    @Test
    void 구매_수량만큼_로또가_정상_발행된다() {
        int quantity = 5;
        Lottos lottos = Lottos.generateLottos(quantity);

        assertNotNull(lottos);
        assertEquals(quantity, lottos.getLottos().size());
    }
}
