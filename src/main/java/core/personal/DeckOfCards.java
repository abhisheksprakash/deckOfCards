package core.personal;

import core.personal.util.Utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeckOfCards {
    // do not allow a card to be created outside of the deck
    // cannot be private, members need to be accessible to DeckOfCards
    // can be public, but the access will be given to this class from outside the package.
    protected class Card {
        private String cardNumber;
        private String cardSuit;

        public Card(String cardNumber, String cardSuit) {
            this.cardNumber = cardNumber;
            this.cardSuit = cardSuit;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public String getCardSuit() {
            return cardSuit;
        }
    }

    private List<Card> cards;

    private int numberOfCards = 52;

    private List<String> cardNumbers = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
    private List<String> cardSuits = Arrays.asList("Spade", "Diamond", "Club", "Heart");

    public DeckOfCards() {
        init();
    }

    private void init() {
        this.cards = new ArrayList<>(this.numberOfCards);

        for (int i = 0; i < this.cardSuits.size(); i++) {
            for (int j = 0; j < this.cardNumbers.size(); j++) {
                this.cards.add(new Card(this.cardNumbers.get(j), this.cardSuits.get(i)));
            }
        }
    }

    public void shuffle(boolean resetDeckToDefault) {
        if (resetDeckToDefault) {
            // reset to the default brand new deck
            init();
        } else {
            for (int i = 0; i < this.numberOfCards; i++) {
                // get a random number between 0 and 52. the utility never returns max.
                int newCardIndex = Utilities.getRandomNumber(i, this.numberOfCards);

                // swap the cards in current index and the newly computed random index
                Card cardTemp = this.cards.get(i);
                this.cards.set(i, this.cards.get(newCardIndex));
                this.cards.set(newCardIndex, cardTemp);
            }
        }
    }

    public void shuffle() {
        shuffle(false);
    }

    public Card dealOneCard() {
        // check if the entire deck is dealt
        if (this.cards.size() == 0) {
            return null;
        }

        // do not return the top card, will force every item in the list to be moved.
        return cards.remove(this.cards.size() - 1);
    }
}
