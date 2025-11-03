package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningNumbersTest {
    @Test
    void 당첨_번호가_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers(" , , , , , "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4,5", "1,2,3,4,5,46", "-1,1,2,3,4,5"})
    void 당첨_번호가_1부터_45_사잇값이_아니면_예외가_발생한다(String numbers) {
        assertThatThrownBy(() -> new WinningNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
    }

    @Test
    void 당첨_번호가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,6,7"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 6개여야 합니다.");
    }

    @Test
    void 당첨_번호에_숫자와_쉼표_외의_다른_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1.2.3.4.5.6"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 숫자만 입력할 수 있습니다.");
    }

    @Test
    void 당첨_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new WinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 당첨 번호는 중복될 수 없습니다.");
    }
}
