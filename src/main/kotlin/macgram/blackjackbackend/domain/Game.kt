package macgram.blackjackbackend.domain

import macgram.blackjackbackend.domain.user.Dealer
import macgram.blackjackbackend.domain.user.Gamer
import java.util.ArrayList

import macgram.blackjackbackend.domain.card.Card;
import macgram.blackjackbackend.domain.card.Cards;
import macgram.blackjackbackend.domain.user.Player;


class Game {
    private val INIT : Int = 0
    private val MAX : Int = 2

    private val dealer : Dealer = Dealer()
    private var players : MutableList<Player> = ArrayList()
    lateinit var cards : ArrayDeque<Card>

    fun addPlayer(player : Player) {
        players.add(player)
    }

    fun removePlayer(player : Player) {
        players.remove(player);
    }

    fun start() {
        validateStart();
        cards = generateCards();
        distributeCard();
    }

    fun validateStart() {
        if (players.stream().anyMatch { it.getBattingMoney() <= 0 }) {
            throw IllegalArgumentException("배팅하지 않은 사용자가 존재 합니다.");
        }
    }

    fun continueDealerCard() {
        dealer.continueCard(cards);
    }

    fun isEnded() : Boolean {
        return players.stream()
            .noneMatch(Player::isContinued);
    }

    fun distributeCard() {
        for (i in INIT until MAX) {
            addDealerCard();
            addPlayersCard();
        }
    }

    fun addDealerCard() {
        addCard(dealer);
    }

    fun addPlayersCard() {
        players.stream()
            .filter(Player::isContinued)
            .forEach(this::addCard);
    }

    fun generateCards() : ArrayDeque<Card> {
        var cards : ArrayDeque<Card>  =  ArrayDeque();
        cards.addAll(Cards.shuffle());

        return cards;
    }

    fun getDealer() : Dealer {
        return dealer;
    }

    fun getPlayers() : List<Player> {
        return players;
    }

    private fun addCard(gamer : Gamer) {
        gamer.addCard(cards.removeFirstOrNull());
    }
}
