package macgram.blackjackbackend.serivce

import macgram.blackjackbackend.domain.user.Account
import macgram.blackjackbackend.dto.LoginDto
import macgram.blackjackbackend.repository.AccountRepository
import org.springframework.stereotype.Service

@Service
class AuthService(val accountRepository: AccountRepository) {
    fun login(loginDto: LoginDto): Account {
        return accountRepository.findByIdAndPassword(loginDto.id, loginDto.password)
    }
}
