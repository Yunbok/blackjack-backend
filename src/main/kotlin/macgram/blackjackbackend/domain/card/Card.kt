package macgram.blackjackbackend.domain.card;

class Card(
    private val pattern: Pattern,
    private val number: Number
) {
    fun isAce(): Boolean {
        return this.number == Number.ACE
    }
}
