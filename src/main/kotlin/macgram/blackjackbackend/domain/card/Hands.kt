package macgram.blackjackbackend.domain.card;

import java.util.*
import kotlin.collections.ArrayList

class Hands {
    companion object {
        private const val BLACKJACK = 21
    }

    private val hands: ArrayList<Card> = ArrayList()

    fun add(card: Card) {
        hands.add(card)
    }

    fun isBlackJack(): Boolean {
        return calScore() == BLACKJACK
    }

    fun isBusted(): Boolean {
        return isOverBlackjack(calScore())
    }

    fun calScore(): Int {
        var sum = sum()
        val aceCount = countAce()
        for (i in 1 .. aceCount) {
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
        return hands.stream()
            .mapToInt(Card::getScore)
            .sum()
    }

    private fun countAce(): Int {
        return hands.stream()
            .filter(Card::isAce)
            .count()
            .toInt()
    }

    fun getCards(): List<Card> {
        return Collections.unmodifiableList(hands)
    }

    override fun toString(): String {
        return "Hands(hands=$hands)"
    }


}
