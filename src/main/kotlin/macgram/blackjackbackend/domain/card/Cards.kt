public class Cards {
    public const val cards = MutableListOf<Card>()

    companion object {
        for (pattern : Pattern.values()) {
            Number.values().forEach {
                cards.add(Card(pattern, it))
            }
        }
    }

    private Cards() {
    }

    public fun shuffle() : List<Card> {
        val copy = MutableListOf<Card>()
        copy.shuffled()

        return copy
    }

}
