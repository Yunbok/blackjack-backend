package macgram.blackjackbackend

import macgram.blackjackbackend.domain.Game
import macgram.blackjackbackend.domain.user.Player
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BlackjackBackendApplication

fun main(args: Array<String>) {
    runApplication<BlackjackBackendApplication>(*args)
}
