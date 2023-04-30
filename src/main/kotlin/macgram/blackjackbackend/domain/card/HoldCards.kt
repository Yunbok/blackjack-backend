package macgram.blackjackbackend.domain.card;

import java.util.*
import java.util.stream.IntStream
import kotlin.collections.ArrayList

class HoldCards(
    val cards: ArrayList<Card>
) {
    companion object {
        const val MAX_SUM = 21
        const val ONE = 0
        const val ELEVEN = 1
    }

    fun add(card: Card) {
        cards.add(card)
    }

    fun isBlackJack(): Boolean {
        return calculate() == MAX_SUM
    }

    fun over(): Boolean {
        return MAX_SUM < calculate()
    }

    fun calculate(): Int {
        if (existsAce()) {
            return calculateAce()
        }
        return sum()
    }

    private fun calculateAce(): Int {
        val one = Number.ACE.score[ONE]
        val eleven = Number.ACE.score[ELEVEN]

        if (eleven + sum() > MAX_SUM) {
            return one + sum()
        }

        return eleven + sum()
    }

    private fun sum(): Int {
        return cards.stream()
            .filter { !it.isAce() }
            .map { it.number }
            .map { it.score }
            .flatMapToInt { IntStream.of(it[ONE]) }
            .sum()
    }

    private fun existsAce(): Boolean {
        return cards.stream()
            .anyMatch(Card::isAce)
    }

    fun removeAll() {
        cards.removeAll(cards)
    }

    fun getCards(): List<Card> {
        return Collections.unmodifiableList(cards)
    }
}
