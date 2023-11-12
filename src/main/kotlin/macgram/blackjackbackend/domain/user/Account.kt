package macgram.blackjackbackend.domain.user

import jakarta.persistence.*

@Entity
open class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var seq: Long = 0L

    @Column(unique = true)
    open lateinit var id: String

    @Column(unique = true)
    open lateinit var nickname: String

    @Column
    open lateinit var password: String
}
