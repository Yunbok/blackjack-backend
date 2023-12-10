package macgram.blackjackbackend

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin(origins = ["*"])
@SpringBootApplication
class BlackjackBackendApplication

fun main(args: Array<String>) {
    runApplication<BlackjackBackendApplication>(*args)
}
