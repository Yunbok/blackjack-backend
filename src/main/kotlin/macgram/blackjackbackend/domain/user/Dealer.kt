package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.Deck
import macgram.blackjackbackend.domain.card.Hands

class Dealer : Gamer {
    var hands: Hands = Hands()

    companion object {
        const val MAX_SUM = 17
    }

    override fun addCard(card: Card) {
        hands.add(card)
    }

    override fun calculate(): Int {
        return hands.calScore()
    }

    override fun reset() {
        hands = Hands()
    }

    fun continueCard(deck: Deck) {
        while (hands.calScore() < MAX_SUM) {
            hands.add(deck.pop())
        }
    }

    override fun toString(): String {
        return "Dealer(hands=$hands)"
    }
}

