package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.HoldCards

class Dealer : Gamer {
    private val maxSum = 17
    private val cards = HoldCards()

    override fun addCard(card: Card) {
        cards.add(card)
    }

    override fun calculate(): Int {
        return cards.calculate()
    }

    override fun reset() {
        cards.removeAll()
    }

    fun continueCard(card: ArrayDeque<Card>) {
        while (this.cards.calculate() < maxSum) {
            this.cards.add(card.removeFirstOrNull())
        }
    }
}

