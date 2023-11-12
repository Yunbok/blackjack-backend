package macgram.blackjackbackend.repository

import macgram.blackjackbackend.domain.user.Billing
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BillingRepository : JpaRepository<Billing, Long> {
    @Query("select sum(billing.money) from Billing billing where billing.account.seq = :seq")
    fun getBalance(seq: Long): Long
}
