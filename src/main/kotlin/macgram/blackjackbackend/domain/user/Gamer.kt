package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card

interface Gamer {
    fun addCard(card: Card)
    fun calculate(): Int
    fun reset()

}
