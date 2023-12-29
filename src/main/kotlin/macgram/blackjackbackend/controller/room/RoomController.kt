package macgram.blackjackbackend.controller.room

import macgram.blackjackbackend.domain.room.Room
import macgram.blackjackbackend.domain.user.Player
import macgram.blackjackbackend.dto.LoginDto
import macgram.blackjackbackend.serivce.AuthService
import macgram.blackjackbackend.serivce.RoomService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/room")
@RestController
class RoomController(private val authService: AuthService, private val roomService: RoomService) {

    @PostMapping
    fun create() {
        val account = authService.login(LoginDto("cj", "1234"))
        roomService.create(Player(account, 1000L))
    }

    @GetMapping
    fun getRoom(): ResponseEntity<Room> {
        return ResponseEntity.ok(roomService.getRoom("room"))
    }
}
