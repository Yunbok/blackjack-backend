package macgram.blackjackbackend.domain.user;

public interface Gamer {
    void addCard(final Card card);

    int calculate();

    void reset();
}
