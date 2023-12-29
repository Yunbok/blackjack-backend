package macgram.blackjackbackend.domain.room

import macgram.blackjackbackend.domain.user.Dealer
import macgram.blackjackbackend.domain.user.Player

class Room(val creator: Player) {
    val number: Int = 10
    val players: Players = Players()
    val dealer: Dealer = Dealer()
}
