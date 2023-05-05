package macgram.blackjackbackend

import macgram.blackjackbackend.domain.Game
import macgram.blackjackbackend.domain.user.Player
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class BlackjackBackendApplication

fun main(args: Array<String>) {
//    runApplication<BlackjackBackendApplication>(*args)

    val game = Game()
    val player = Player(1000000L)
    player.batting(10000L)
    game.addPlayer(player)
    game.start()

    while (!game.isEnded()) {
        game.players
            .stream()
            .filter { it.continuable }
            .forEach {
                it.continuable = true
            }
        game.addPlayersCard()
    }

    game.continueDealerCard()
    println("-----------------")

    println("딜러: " + game.dealer.calculate())
    println(game.dealer.hands)
    game.players.forEach { println("유저: " + it.calculate()) }
    game.players.forEach { println(it.hands) }
    println("-----------------")

}
