package macgram.blackjackbackend.domain.card

import java.util.*
import kotlin.collections.ArrayDeque

class Deck {
    private val deck: ArrayDeque<Card> = ArrayDeque()

    init {
        for (pattern in Pattern.values()) {
            Arrays.stream(Number.values())
                .forEach { deck.add(Card(pattern, it))}
        }
    }

    fun shuffle() {
        deck.shuffle()
    }

    fun pop(): Card {
        return deck.removeFirst()
    }

}
