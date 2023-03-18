package macgram.blackjackbackend.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class HoldCards {
    private final int MAX_SUM = 21;
    private final int ONE = 0;
    private final int ELEVEN = 1;

    private final List<Card> cards = new ArrayList<>();

    public void add(final Card card) {
        cards.add(card);
    }

    public boolean isBlackJack() {
        return MAX_SUM == calculate();
    }

    public boolean over() {
        return MAX_SUM < calculate();
    }

    public int calculate() {
        if (existsAce()) {
            return calculateAce();
        }
        return sum();
    }

    private int calculateAce() {
        int one = Number.ACE.getScore()[ONE];
        int eleven = Number.ACE.getScore()[ELEVEN];

        if (eleven + sum() > MAX_SUM) {
            return one + sum();
        }

        return eleven + sum();
    }

    private int sum() {
        return cards.stream()
                .filter(it -> !it.equalsAce())
                .map(Card::getNumber)
                .map(Number::getScore)
                .flatMapToInt(it -> IntStream.of(it[ONE]))
                .sum();
    }

    private boolean existsAce() {
        return cards.stream()
                .anyMatch(Card::equalsAce);
    }

    public void removeAll() {
        cards.removeAll(cards);
    }

    public List<Card> getCards() {
        return Collections.unmodifiableList(cards);
    }
}
