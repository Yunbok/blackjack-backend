package macgram.blackjackbackend.domain.user;

import macgram.blackjackbackend.domain.card.HoldCards;

import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Dealer implements Gamer {
    public static final int MAX_SUM = 17;
    private final HoldCards cards = new HoldCards();

    @Override
    public void addCard(final Card card) {
        cards.add(card);
    }

    public void continueCard(final Queue<Card> cards) {
        while (this.cards.calculate() < MAX_SUM) {
            this.cards.add(cards.poll());
        }
    }

    @Override
    public int calculate() {
        return cards.calculate();
    }

    @Override
    public void reset() {
        cards.removeAll();
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Dealer dealer = (Dealer) o;
        return Objects.equals(cards, dealer.cards);
    }

    @Override
    public String toString() {
        return "Dealer{" +
                "cards=" + cards +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(cards);
    }
}
