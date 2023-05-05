package macgram.blackjackbackend.domain.card;

class Card(
    private val pattern: Pattern,
    private val number: Number
) {
    fun isAce(): Boolean {
        return number == Number.ACE
    }

    fun getScore(): Int {
        return number.score
    }

    override fun toString(): String {
        return "Card(pattern=$pattern, number=$number)"
    }
}
