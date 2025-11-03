package lotto.domain;

public enum WinningRank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    MISS(0, false, 0L);

    private final int matchCount;
    private final boolean bonusMatched;
    private final long winningMoney;

    WinningRank(int matchCount, boolean bonusMatched, long winningMoney) {
        this.matchCount = matchCount;
        this.bonusMatched = bonusMatched;
        this.winningMoney = winningMoney;
    }

    public static WinningRank of(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && bonusMatched) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return MISS;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatched() {
        return bonusMatched;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}