package macgram.blackjackbackend.domain

import macgram.blackjackbackend.domain.user.Dealer
import macgram.blackjackbackend.domain.user.Gamer
import java.util.ArrayList

import macgram.blackjackbackend.domain.card.Deck
import macgram.blackjackbackend.domain.user.Player


class Game {
    private val INIT: Int = 0
    private val MAX: Int = 2

    val dealer: Dealer = Dealer()
    var players: MutableList<Player> = ArrayList()
    lateinit var deck: Deck

    fun addPlayer(player: Player) {
        players.add(player)
    }

    fun removePlayer(player: Player) {
        players.remove(player)
    }

    fun start() {
        validateStart()
        deck = generateCards()
        deck.shuffle()
        distributeCard()
        println(dealer)
        println(players)

    }

    fun validateStart() {
        if (players.any { it.battingMoney <= 0 }) {
            throw IllegalArgumentException("배팅하지 않은 사용자가 존재 합니다.")
        }
    }

    fun continueDealerCard() {
        dealer.continueCard(deck)
    }

    fun isEnded(): Boolean {
        return players.none { it.continuable }
    }

    fun distributeCard() {
        for (i in INIT until MAX) {
            addDealerCard()
            addPlayersCard()
        }
    }

    fun addDealerCard() {
        addCard(dealer)
    }

    fun addPlayersCard() {
        players.filter(Player::continuable)
            .forEach(this::addCard)
    }

    fun generateCards(): Deck {
        return Deck()
    }

    private fun addCard(gamer: Gamer) {
        gamer.addCard(deck.pop())
    }
}
