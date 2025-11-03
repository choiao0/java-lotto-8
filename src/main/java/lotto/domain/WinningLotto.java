package lotto.domain;

public class WinningLotto {
    private final WinningRank rank;
    private final Lotto lotto;

    public WinningLotto(WinningRank rank, Lotto lotto) {
        this.rank = rank;
        this.lotto = lotto;
    }

    public WinningRank getRank() {
        return rank;
    }

    public Lotto getLotto() {
        return lotto;
    }
}