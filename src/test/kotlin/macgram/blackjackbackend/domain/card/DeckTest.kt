package macgram.blackjackbackend.domain.card

import org.junit.jupiter.api.Test

class DeckTest {

    @Test
    fun initDeck() {
        val deck = Deck()

        val deckSize = deck.deck.count()
        println(deckSize)
//        assert(deckSize == 56)
    }
}
