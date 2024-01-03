package macgram.blackjackbackend.domain.card;

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*

class Hands {
    companion object {
        private const val BLACKJACK = 21
    }

    private val hands: ArrayList<Card> = ArrayList()

    fun add(card: Card) {
        hands.add(card)
    }

    @JsonIgnore
    fun isBlackJack(): Boolean {
        return calScore() == BLACKJACK
    }

    @JsonIgnore
    fun isBusted(): Boolean {
        return isOverBlackjack(calScore())
    }

    fun calScore(): Int {
        var sum = sum()
        val aceCount = countAce()

        for (i in 1..aceCount) {
            if (!isOverBlackjack(sum))
                return sum
            sum -= 10
        }
        return sum
    }

    private fun isOverBlackjack(sum: Int): Boolean {
        return sum > BLACKJACK
    }

    private fun sum(): Int {
        return hands.sumOf(Card::getScore)
    }

    private fun countAce(): Int {
        return hands.count(Card::isAce)
    }

    @JsonIgnore
    fun getHands(): List<Card> {
        return Collections.unmodifiableList(hands)
    }

    override fun toString(): String {
        return "Hands(hands=$hands)"
    }


}
