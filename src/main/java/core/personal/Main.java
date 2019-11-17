package core.personal;

public class Main {
    public static void main(String[] args) {
        DeckOfCards doc = new DeckOfCards();
        doc.shuffle();
        DeckOfCards.Card card = doc.dealOneCard();
        System.out.println("Card number: " + card.getCardNumber() + ". Suit: " + card.getCardSuit());
    }
}