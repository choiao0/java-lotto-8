package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class WinningRankTest {
    @Test
    void 맞은_개수에_따른_순위_생성을_확인한다() {
        assertThat(WinningRank.of(6, false)).isEqualTo(WinningRank.FIRST);
        assertThat(WinningRank.of(5, true)).isEqualTo(WinningRank.SECOND);
        assertThat(WinningRank.of(5, false)).isEqualTo(WinningRank.THIRD);
        assertThat(WinningRank.of(4, false)).isEqualTo(WinningRank.FOURTH);
        assertThat(WinningRank.of(3, false)).isEqualTo(WinningRank.FIFTH);
        assertThat(WinningRank.of(2, false)).isEqualTo(WinningRank.MISS);
    }

    @Test
    void 순위에_따른_상금을_확인한다() {
        assertThat(WinningRank.FIRST.getWinningMoney()).isEqualTo(2000000000L);
        assertThat(WinningRank.SECOND.getWinningMoney()).isEqualTo(30000000L);
        assertThat(WinningRank.THIRD.getWinningMoney()).isEqualTo(1500000L);
        assertThat(WinningRank.FOURTH.getWinningMoney()).isEqualTo(50000L);
        assertThat(WinningRank.FIFTH.getWinningMoney()).isEqualTo(5000L);
        assertThat(WinningRank.MISS.getWinningMoney()).isEqualTo(0L);
    }
}
