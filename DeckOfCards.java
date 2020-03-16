
import java.util.Random;

/**
 * 1. The program encapsulated the variables in DeckOfCards. 2. The most challenging part was
 * knowing where the variables were being stored.
 * 
 * @author mattfuller
 *
 */
public class DeckOfCards implements DeckOfCardsInterface {
	// These are the only instance variables you will need.
	private final int DECKSIZE = 52;
	private Card[] cards;
	private int nextCardIndex;
	private int cardsRemaining;
	private int cardsDealt;

	public DeckOfCards()
		{
			restoreDeck();
		}

	@Override
	public void shuffle() {
		Random generator = new Random();

		// Attempt to swap each card with a random card in the deck.
		// This isn't a perfect random shuffle but it is a simple one.
		// A better shuffle requires a more complex algorithm.

		for (int i = 0; i < cards.length; i++) {
			int j = generator.nextInt(cards.length);
			Card temp = cards[i];
			cards[i] = cards[j];
			cards[j] = temp;
		}

		// Reset instance variable that keeps track of dealt and remaining cards.
		nextCardIndex = 0;
	}

	@Override
	public String toString() {
		String output = "";
		for (int i = 0; i < DECKSIZE; i++) {
			if (i % 4 == 0) {
				output += "\n";
			}
			output += cards[i].toString();
		}
		return output;
	}

	@Override
	public Card draw() {
		nextCardIndex++;
		if (nextCardIndex > DECKSIZE) {
			return null;
		}
		return cards[nextCardIndex - 1];
	}

	@Override
	public int numCardsRemaining() {
		cardsRemaining = DECKSIZE - nextCardIndex;
		return cardsRemaining;
	}

	@Override
	public int numCardsDealt() {
		cardsDealt = nextCardIndex;
		return cardsDealt;
	}

	@Override
	public void restoreDeck() {
		cards = new Card[DECKSIZE];
		int i = 0;
		for (Suit s : Suit.values()) {
			for (FaceValue v : FaceValue.values()) {
				// Create new card and add it to your deck.
				cards[i] = new Card(s, v);
				i++;
			}
		}
		nextCardIndex = 0;
	}

	@Override
	public Card[] dealtCards() {
		Card[] dealtCards = new Card[cardsDealt];
		for (int i = 0; i < cardsDealt; i++) {
			dealtCards[i] = cards[i];
		}
		return dealtCards;
	}

	@Override
	public Card[] remainingCards() {
		Card[] remainingCards = new Card[cardsRemaining];
		for (int i = nextCardIndex; i < DECKSIZE; i++) {
			remainingCards[i] = cards[i];
		}
		return remainingCards;
	}

}
