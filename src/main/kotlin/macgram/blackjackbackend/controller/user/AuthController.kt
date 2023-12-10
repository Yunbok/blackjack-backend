package macgram.blackjackbackend.controller.user

import macgram.blackjackbackend.domain.user.Account
import macgram.blackjackbackend.dto.LoginDto
import macgram.blackjackbackend.serivce.AuthService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AuthController(val authService: AuthService) {
    @PostMapping("/login")
    fun login(@RequestBody loginDto: LoginDto): ResponseEntity<Account> {
        return ResponseEntity.ok(authService.login(loginDto))
    }
}
