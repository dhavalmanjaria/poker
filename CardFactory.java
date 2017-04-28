
public class CardFactory {
	
	public Card createCard(String cardName) throws IllegalArgumentException {
		if (cardName.length() > 3) { // three for no. 10 cards
			throw new IllegalArgumentException("Card value must two characters only, one for the value and one for suite eg: 7s, qh");
		}
		
		char val = cardName.charAt(0);
		char suite;
		if (val == '1') {
			// It's a 10 card.
			// Since this is a special case, a one-off if statement seems best. 

			suite = cardName.charAt(2);
		}
		else
			suite = cardName.charAt(1);
		
		// If the val is not an integer, then the setNumber(char) method is called
		// otherwise the setNumber(int) method is called.
		// This may be a bad use of polymorphism. Or a really good one.
		// It all depends on how well the code can be followed.
		Card c = new Card();

		try {
			int n = Integer.parseInt(val + "");
			if (n == 1)
				n = 10;
			c.setNumber(n);
		}
		catch(NumberFormatException nfe) {
			c.setNumber(val);
		}
		
		c.setSuite(suite);
		
		return c;
	}
}
