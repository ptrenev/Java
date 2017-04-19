package blackjack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petko-PC on 4/19/2017.
 */
public class Deck {

    private List<PokerCard> cards = new ArrayList<>();

    /**
     * Create a new poker deck and populate the deck with one copy
     * of every playing card
     */
    public Deck() {
        // hearts, diamonds, clubs, spades
        for (int suit = 0; suit < 4; suit++){
            // goes ace through king
            for (int value = 1; value <= 13; value++) {
                PokerCard card = new PokerCard(suit, value); // creates 52 unique poker cards, but exists only to here
                cards.add(card); // creates the actual deck
            }
        }
    }

    public void shuffleDeck() {
        // creates an empty ArrayList with no cards
        List<PokerCard> shuffledDeck = new ArrayList<>();

        // Iterate through the existing deck
        while (!cards.isEmpty()){
            // gets a random card [0-52]
            // Math.random has to be in parenthesis because of precedence
            int randomCard = (int) (Math.random() * cards.size());
            // Removes the card at the given index
            PokerCard tempCard = cards.remove(randomCard);
            // Adds the removed card from the right deck to the shuffled deck
            shuffledDeck.add(tempCard);
        }
        // Assign the shuffled deck to the right deck, because of scope
        cards = shuffledDeck;
    }

    public int size() {
        return cards.size();
    }

    public List<PokerCard> getCards() {
        return cards;
    }
}
