package macgram.blackjackbackend.domain.card;

class Card(
    val pattern: Pattern,
    val number: Number
) {
    fun isAce(): Boolean {
        return this.number == Number.ACE
    }
}
