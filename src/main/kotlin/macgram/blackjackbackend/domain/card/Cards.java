package macgram.blackjackbackend.domain.card;

import com.example.blackjack.domain.card.Card;
import com.example.blackjack.domain.card.Number;
import com.example.blackjack.domain.card.Pattern;

import java.util.*;

public class Cards {
    public static final List<Card> cards = new ArrayList<>();

    static {
        for (Pattern pattern : Pattern.values()) {
            Arrays.stream(Number.values())
                    .forEach(it -> cards.add(new Card(pattern, it)));
        }
    }

    private Cards() {
    }

    public static List<Card> shuffle() {
        List<Card> copy = new ArrayList<>();
        copy.addAll(cards);

        Collections.shuffle(copy);
        return copy;
    }

}

