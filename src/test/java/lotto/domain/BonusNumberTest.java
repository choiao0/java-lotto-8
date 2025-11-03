package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BonusNumberTest {
    @Test
    void 보너스_번호가_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber(" "))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 공백일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void 보너스_번호가_1부터_45_사잇값이_아니면_예외가_발생한다(String number) {
        assertThatThrownBy(() -> new BonusNumber(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1과 45 사이여야 합니다.");
    }

    @Test
    void 보너스_번호에_숫자_외의_다른_문자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("1.2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 숫자만 입력할 수 있습니다.");
    }
}
