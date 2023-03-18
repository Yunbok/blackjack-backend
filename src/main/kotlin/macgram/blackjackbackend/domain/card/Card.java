package macgram.blackjackbackend.domain.card;

import java.util.Objects;

public class Card {
    private Pattern pattern;
    private Number number;

    public Card(final Pattern pattern, final Number number) {
        this.pattern = pattern;
        this.number = number;
    }

    public boolean equalsAce() {
        return Number.ACE.equals(this.number);
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Card card = (Card) o;
        return pattern == card.pattern && number == card.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern, number);
    }

    @Override
    public String toString() {
        return "Card{" +
                "pattern=" + pattern +
                ", number=" + number +
                '}';
    }


}
