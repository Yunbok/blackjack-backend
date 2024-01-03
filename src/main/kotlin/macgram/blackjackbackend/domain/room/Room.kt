package macgram.blackjackbackend.domain.room

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import macgram.blackjackbackend.domain.user.Dealer
import macgram.blackjackbackend.domain.user.Player

class Room @JsonCreator constructor(@JsonProperty("creator") val creator: Player) {

    val number: Int = 10
    val players: Players = Players()
    val dealer: Dealer = Dealer()
}
