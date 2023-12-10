package macgram.blackjackbackend.domain.user

import jakarta.persistence.*

@Entity
open class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var seq: Long = 0L

    @Column
    open lateinit var type: String

    @ManyToOne
    @JoinColumn(name = "account_seq")
    open lateinit var account: Account

    @Column
    open var money: Long = 0L
}
