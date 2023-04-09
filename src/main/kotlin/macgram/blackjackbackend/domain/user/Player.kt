package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.HoldCards

class Player : Gamer {
    val MIN_MONEY = 0L
    val MAX_SUM = 21L
    val cards = HoldCards()

    var money = 0L
    var battingMoney = 0L
    var continuable = true

    fun Player(money: Long) {
        this.money = money
    }

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
            this.cards.add(card)
        }

        if (calculate() >= MAX_SUM) {
            this.continuable = false
        }
    }

    override fun calculate(): Int {
        return this.cards.calculate()
    }

    fun over(): Boolean {
        return this.cards.over()
    }

    override fun reset() {
        this.cards.removeAll()
        this.continuable = true
        this.battingMoney = 0L
    }

    override fun toString(): String {
        return "Player{" +
                "money=" + money +
                ", cards=" + cards +
                ", isContinued=" + continuable +
                ", battingMoney=" + battingMoney +
                '}'
    }
}
