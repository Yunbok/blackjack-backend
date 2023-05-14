package macgram.blackjackbackend.domain.card

class Deck {
    private val deck: ArrayDeque<Card> = ArrayDeque()

    init {
        for (pattern in Pattern.values()) {
            Number.values()
                .forEach { deck.add(Card(pattern, it)) }
        }
    }

    fun shuffle() {
        deck.shuffle()
    }

    fun pop(): Card {
        return deck.removeFirst()
    }

}
