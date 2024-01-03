package macgram.blackjackbackend.domain.room

import macgram.blackjackbackend.domain.user.Player

class Players {
    private val players: MutableList<Player> = ArrayList()

    fun join(player: Player) {
        players.add(player)
    }

    fun disconnect(player: Player) {
        players.remove(player)
    }
}
