
public class CardDealer {

	public static void main(String[] args) {

		DeckOfCards cards = new DeckOfCards();
		System.out.println("fresh, unshuffled deck");
		System.out.println(cards.toString());
		System.out.println();
		System.out.println();

		cards.shuffle();
		System.out.println("shuffled deck");
		System.out.println(cards.toString());
		System.out.println();

		int winner = 0;
		while (cards.numCardsRemaining() >= 2) {

			Card player1 = cards.draw();
			Card player2 = cards.draw();
			System.out.println("Drawing cards...");
			if (player1.compareTo(player2) > 0) {
				// player 1's card is bigger so they win
				winner = 1;
				System.out.println("Player 1: " + player1);
				System.out.println("Player 2: " + player2);
				System.out.println("Player " + winner + " wins!\n");
			} else if (player1.compareTo(player2) < 0) {
				// player 1's card is bigger so they win
				winner = 2;
				System.out.println("Player 1: " + player1);
				System.out.println("Player 2: " + player2);
				System.out.println("Player " + winner + " wins!\n");
			} else {
				winner = 3;
				System.out.println("Player 1: " + player1);
				System.out.println("Player 2: " + player2);
				System.out.println("Everyone wins!\n");
			}

		}
		System.out.println();
		System.out.println("restored deck");
		DeckOfCards restored = new DeckOfCards();
		System.out.println(restored);
	}

}
