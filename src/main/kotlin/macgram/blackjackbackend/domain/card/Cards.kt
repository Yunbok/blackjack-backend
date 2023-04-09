package macgram.blackjackbackend.domain.card

class Cards(list: MutableList<Card>) {
    private val list: MutableList<Card>

    init {
        this.list = list
    }

    fun getList(): List<Card> = this.list
}
