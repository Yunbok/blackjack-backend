package macgram.blackjackbackend.repository

import macgram.blackjackbackend.domain.user.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByIdAndPassword(id: String, password: String): Account
}
