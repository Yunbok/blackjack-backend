package macgram.blackjackbackend.domain;

import macgram.blackjackbackend.domain.card.Card;
import macgram.blackjackbackend.domain.card.Cards;
import macgram.blackjackbackend.domain.user.Dealer;
import macgram.blackjackbackend.domain.user.Gamer;
import macgram.blackjackbackend.domain.user.Player;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    private static final int INIT = 0;
    private static final int MAX = 2;

    private final Dealer dealer = new Dealer();
    private final List<Player> players = new ArrayList<>();
    private Queue<Card> cards;

    public void addPlayer(final Player player) {
        players.add(player);
    }

    public void removePlayer(final Player player) {
        players.remove(player);
    }

    public void start() {
        validateStart();
        cards = generateCards();
        distributeCard();
    }

    public void validateStart() {
        if (players.stream().anyMatch(it -> it.getBattingMoney() <= 0)) {
            throw new IllegalArgumentException("배팅하지 않은 사용자가 존재 합니다.");
        }
    }

    public void continueDealerCard() {
        dealer.continueCard(cards);
    }

    public boolean isEnded() {
        return players.stream()
                .noneMatch(Player::isContinued);
    }

    private void distributeCard() {
        for (int i = INIT; i < MAX; i++) {
            addDealerCard();
            addPlayersCard();
        }
    }

    public void addDealerCard() {
        addCard(dealer);
    }

    public void addPlayersCard() {
        players.stream()
                .filter(Player::isContinued)
                .forEach(this::addCard);
    }

    private void addCard(final Gamer gamer) {
        gamer.addCard(cards.poll());
    }

    public void mola() {
        int calculate = dealer.calculate();
    }

    private Queue<Card> generateCards() {
        Queue<Card> cards = new LinkedList<>();
        cards.addAll(Cards.shuffle());

        return cards;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
