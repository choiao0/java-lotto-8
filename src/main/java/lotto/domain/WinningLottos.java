package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningLottos {
    private final List<WinningLotto> winningLottos;

    private WinningLottos(List<WinningLotto> winningLottos) {
        this.winningLottos = new ArrayList<>(winningLottos);
    }

    public static WinningLottos of(Lottos lottos, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        List<WinningLotto> matchedLottos = new ArrayList<>();
        List<Integer> winning = winningNumbers.getNumbers();
        int bonus = bonusNumber.getBonusNumber();

        for (Lotto lotto : lottos.getLottos()) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winning::contains)
                    .count();
            boolean bonusMatched = lotto.getNumbers().contains(bonus);

            WinningRank rank = WinningRank.of(matchCount, bonusMatched);
            if (rank != WinningRank.MISS) {
                matchedLottos.add(new WinningLotto(rank, lotto));
            }
        }
        return new WinningLottos(matchedLottos);
    }

    public Map<WinningRank, Long> countsByRank() {
        return winningLottos.stream()
                .collect(Collectors.groupingBy(WinningLotto::getRank, Collectors.counting()));
    }
}