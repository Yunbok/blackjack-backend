package macgram.blackjackbackend.domain.user;

import java.math.BigDecimal;
import java.util.Objects;

public class Player implements Gamer {
    private final int MIN_MONEY = 0;
    private final int MAX_SUM = 21;

    private BigDecimal money;
    private final HoldCards cards = new HoldCards();
    private boolean isContinued = true;
    private BigDecimal battingMoney = BigDecimal.ZERO;

    public Player(final long money) {
        this.money = BigDecimal.valueOf(money);
    }

    public void batting(final long batting) {
        validateBatting(batting);
        battingMoney = BigDecimal.valueOf(batting);
    }

    private void validateBatting(final long money) {
        if (money == MIN_MONEY) {
            throw new IllegalArgumentException("배팅 금액은 0원 이상 이여야 합니다.");
        }

        if (this.money.longValue() - money < MIN_MONEY) {
            throw new IllegalArgumentException("배팅 금액이 부족합니다.");
        }
    }

    @Override
    public void addCard(final Card card) {
        if (isContinued) {
            cards.add(card);
        }

        if (calculate() >= MAX_SUM) {
            isContinued = false;
        }
    }

    @Override
    public int calculate() {
        return cards.calculate();
    }

    public void checkContinued(final boolean isContinued) {
        this.isContinued = isContinued;
    }

    public boolean over() {
        return cards.over();
    }

    @Override
    public void reset() {
        cards.removeAll();
        isContinued = true;
        battingMoney = BigDecimal.ZERO;
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    public long getBattingMoney() {
        return battingMoney.longValue();
    }

    public boolean isContinued() {
        return isContinued;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Player player = (Player) o;
        return Objects.equals(money, player.money) && Objects.equals(cards, player.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, cards);
    }

    @Override
    public String toString() {
        return "Player{" +
                "money=" + money +
                ", cards=" + cards +
                ", isContinued=" + isContinued +
                ", battingMoney=" + battingMoney +
                '}';
    }
}
