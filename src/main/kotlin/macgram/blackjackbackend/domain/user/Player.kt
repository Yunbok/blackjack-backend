package macgram.blackjackbackend.domain.user

import macgram.blackjackbackend.domain.card.Card
import macgram.blackjackbackend.domain.card.HoldCards
import java.math.BigDecimal

class Player : Gamer {
    val MIN_MONEY = 0L
    val MAX_SUM = 21L
    val cards : HoldCards = HoldCards()

    var money : BigDecimal = BigDecimal.ZERO
    var battingMoney : BigDecimal = BigDecimal.ZERO
    var continueFlag : Boolean = true

    fun Player(money : Long) {
        this.money = BigDecimal.valueOf(money)
    }

    fun batting(batting : Long) {
        validateBatting(batting)
        this.battingMoney = BigDecimal.valueOf(batting)
    }

    fun validateBatting(money : Long) {
        if (money == MIN_MONEY) {
            throw IllegalArgumentException("배팅 금액은 0원 이상 이여야 합니다.")
        }

        if (this.money.toLong() - money < MIN_MONEY) {
            throw IllegalArgumentException("배팅 금액이 부족합니다.")
        }
    }

    override fun addCard(card : Card) {
        if (this.continueFlag) {
            this.cards.add(card)
        }

        if (calculate() >= MAX_SUM) {
            this.continueFlag = false
        }
    }

    override fun calculate() : Int {
        return this.cards.calculate()
    }

    fun checkContinued(isContinued : Boolean) {
        this.continueFlag = isContinued
    }

    fun over() : Boolean {
        return this.cards.over()
    }

    override fun reset() {
        this.cards.removeAll()
        this.continueFlag = true
        this.battingMoney = BigDecimal.ZERO
    }

    fun getCards() : List<Card>  {
        return this.cards.getCards()
    }

    fun getBattingMoney() : Long {
        return this.battingMoney.toLong()
    }

    fun isContinued() : Boolean {
        return this.continueFlag
    }

    override fun toString() : String {
        return "Player{" +
                "money=" + money +
                ", cards=" + cards +
                ", isContinued=" + continueFlag +
                ", battingMoney=" + battingMoney +
                '}'
    }
}