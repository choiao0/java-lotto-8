package lotto.domain;

import java.text.NumberFormat;
import java.util.*;

public class WinningStatistics {
    private static final List<WinningRank> DISPLAY_ORDER = List.of(
            WinningRank.FIFTH,
            WinningRank.FOURTH,
            WinningRank.THIRD,
            WinningRank.SECOND,
            WinningRank.FIRST
    );

    private final Map<WinningRank, Long> counts;
    private final NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

    public WinningStatistics(WinningLottos winningLottos) {
        Map<WinningRank, Long> rankCounts = winningLottos.countsByRank();
        this.counts = new EnumMap<>(WinningRank.class);
        for (WinningRank rank : WinningRank.values()) {
            this.counts.put(rank, rankCounts.getOrDefault(rank, 0L));
        }
    }

    public List<String> formatStatistics() {
        List<String> lines = new ArrayList<>();
        for (WinningRank rank : DISPLAY_ORDER) {
            String label = formatRankLabel(rank);
            String winningMoney = numberFormat.format(rank.getWinningMoney()) + "원";
            long count = counts.getOrDefault(rank, 0L);
            lines.add(String.format("%s (%s) - %d개", label, winningMoney, count));
        }
        return lines;
    }

    private String formatRankLabel(WinningRank rank) {
        String label = rank.getMatchCount() + "개 일치";
        if (rank.isBonusMatched()) {
            label += ", 보너스 볼 일치";
        }
        return label;
    }
}