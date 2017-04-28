import static org.junit.Assert.*;

import org.junit.Test;

public class CreateCardTest {

	@Test
	public void test_createFaceCard() {
		CardFactory cardFact = new CardFactory();
		Card c = cardFact.createCard("qs");
		
		assertTrue(c != null);
		assertTrue(c.getNumber() == 12);
		// 12 for queen
		assertTrue(c.getSuite() == 's');
	}
	
	@Test
	public void test_createTenCard() {
		CardFactory cardFact = new CardFactory();
		Card c = cardFact.createCard("10s");
		
		assertTrue(c != null);
		assertTrue(c.getNumber() == 10);
		// 12 for queen
		assertTrue(c.getSuite() == 's');
	}
	
	@Test
	public void test_createNumberCard() {
		CardFactory cardFact = new CardFactory();
		Card c = cardFact.createCard("7h");
		
		assertTrue(c != null);
		assertTrue(c.getNumber() == 7);
		// 12 for queen
		assertTrue(c.getSuite() == 'h');
	}
}
