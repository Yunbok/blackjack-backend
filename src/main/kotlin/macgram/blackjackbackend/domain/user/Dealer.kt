package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.HoldCards
import java.util.*

const val MAX_SUM = 17

class Dealer : Gamer {
    private val cards = HoldCards()

    override fun addCard(card: Card) {
        cards.add(card);
    }

    override fun calculate(): Int {
        return cards.calculate();
    }

    override fun reset() {
        cards.removeAll()
    }

    fun continueCard(cards: Queue<Card>) {
        while (this.cards.calculate() < MAX_SUM) {
            this.cards.add(cards.poll())
        }
    }

}
