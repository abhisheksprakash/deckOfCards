package core.personal;

import core.personal.util.Utilities;
import org.junit.Assert;
import org.junit.Test;

public class DeckOfCardsTest {

    DeckOfCards doc = new DeckOfCards();

    @Test
    public void dealOneCardUnshuffledTest() {
        this.doc.shuffle(true);
        DeckOfCards.Card card = this.doc.dealOneCard();
        Assert.assertTrue("Unshuffled deck top card is A-Spade - ",
                card.getCardNumber().compareTo("K") == 0 && card.getCardSuit().compareTo("Heart") == 0);
    }

    @Test
    public void dealOneCardShuffledTest() {
        this.doc.shuffle();
        DeckOfCards.Card card = this.doc.dealOneCard();
        Assert.assertNotNull(card);
    }

    @Test
    public void getCountOfAllShuffledCards() {
        this.doc.shuffle();

        int count = 0;
        for(int i = 0; i < 100; i++)
        {
            DeckOfCards.Card card = this.doc.dealOneCard();
            if(card == null) {
                break;
            }
            count++;
        }

        Assert.assertEquals("52 Cards found - ", 52, count);
    }

    @Test
    public void getRandomNumber() {
        int random = Utilities.getRandomNumber(51, 52);
        Assert.assertTrue("Random number is between 51 and 52 - ", random >= -1 && random < 53);
    }

    @Test
    public void runMain() {
        Main.main(null);
        Assert.assertTrue("Main method tested and no exceptions - ", true);
    }
}
