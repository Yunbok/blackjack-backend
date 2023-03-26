package macgram.blackjackbackend.domain.user;

import macgram.blackjackbackend.domain.card.Card;

public interface Gamer {
    void addCard(final Card card);

    int calculate();

    void reset();
}
