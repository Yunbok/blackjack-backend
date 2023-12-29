package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.Hands

class Player(var account: Account, var balance: Long) : Gamer {
    companion object {
        const val MIN_MONEY = 0L
        const val MAX_SUM = 21L
    }

    var hands: Hands = Hands()
    var battingMoney = 0L
    var continuable = true
    val money: Long = 0L


    fun batting(batting: Long) {
        validateBatting(batting)
        this.battingMoney = batting
    }

    fun validateBatting(money: Long) {
        if (money == MIN_MONEY) {
            throw IllegalArgumentException("배팅 금액은 0원 이상 이여야 합니다.")
        }

        if (this.money - money < MIN_MONEY) {
            throw IllegalArgumentException("배팅 금액이 부족합니다.")
        }
    }

    override fun addCard(card: Card) {
        if (this.continuable) {
            this.hands.add(card)
        }

        if (calculate() >= MAX_SUM) {
            this.continuable = false
        }
    }

    override fun calculate(): Int {
        return this.hands.calScore()
    }

    fun over(): Boolean {
        return this.hands.hasBusted()
    }

    override fun reset() {
        hands = Hands()
        continuable = true
        battingMoney = 0L
    }

    override fun toString(): String {
        return "Player(money=$money, hands=$hands, battingMoney=$battingMoney, continuable=$continuable)"
    }


}
