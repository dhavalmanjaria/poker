import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PokerHandTest {

	@Test
	public void test_create_random_hand() {
		// Hand = 7s qs kh
		
		PokerHand hand = new PokerHand ();
		CardFactory cfactory = new CardFactory();
		
		Card[] testCards = new Card[3];
		testCards[0] = cfactory.createCard("7s");
		testCards[1] = cfactory.createCard("qs");
		testCards[2] = cfactory.createCard("kh");
		
		hand.add("7s");
		hand.add("qs");
		hand.add("kh");
		
		ArrayList<Card> cards = hand.getCards();
		
		assertTrue(cards.get(0).equals(testCards[0]));
		assertTrue(cards.get(1).equals(testCards[1]));
		assertTrue(cards.get(2).equals(testCards[2]));
	}
	
	@Test
	public void test_isOnePair() {
		CardFactory cfactory = new CardFactory();
		
		ArrayList<Card> onePair = new ArrayList<Card>();
		onePair.add(cfactory.createCard("4h"));
		onePair.add(cfactory.createCard("4s"));
		onePair.add(cfactory.createCard("ks"));
		onePair.add(cfactory.createCard("10d"));
		onePair.add(cfactory.createCard("5s"));
		
		PokerHand hand = new PokerHand(onePair);
		
		assertTrue(hand.isOnePair());		
	}
	
	@Test
	public void test_isThreeOfAKind() {
		CardFactory cfactory = new CardFactory();
		
		ArrayList<Card> threeOfAKind = new ArrayList<Card>();
		threeOfAKind.add(cfactory.createCard("5h"));
		threeOfAKind.add(cfactory.createCard("5c"));
		threeOfAKind.add(cfactory.createCard("5s"));
		threeOfAKind.add(cfactory.createCard("4s"));
		threeOfAKind.add(cfactory.createCard("9h"));
		
		PokerHand hand = new PokerHand(threeOfAKind);
		assertTrue(hand.isThreeOfAKind());
	}
	
	@Test
	public void test_isFourOfAKind() {
		CardFactory cfactory = new CardFactory();
		

        ArrayList<Card> fourOfAKind = new ArrayList<Card>();
        fourOfAKind.add(cfactory.createCard("5h"));
        fourOfAKind.add(cfactory.createCard("5c"));
        fourOfAKind.add(cfactory.createCard("5s"));
        fourOfAKind.add(cfactory.createCard("5d"));
        fourOfAKind.add(cfactory.createCard("9h"));
        
        PokerHand hand = new PokerHand(fourOfAKind);
        assertTrue(hand.isFourOfAKind());
	}
	
	@Test
	public void test_isStraight() {
		CardFactory cfactory = new CardFactory();
		
		ArrayList<Card> straight = new ArrayList<Card>();
        straight.add(cfactory.createCard("2h"));
        straight.add(cfactory.createCard("3c"));
        straight.add(cfactory.createCard("3d"));
        straight.add(cfactory.createCard("4d"));
        straight.add(cfactory.createCard("4s"));
        straight.add(cfactory.createCard("5s"));
        straight.add(cfactory.createCard("6h"));
        
        PokerHand hand = new PokerHand(straight);
        
        assertTrue(hand.isStraight());
	}
	
	@Test
	public void test_isNotStraight() {
		CardFactory cfactory = new CardFactory();
		
		ArrayList<Card> straight = new ArrayList<Card>();
        straight.add(cfactory.createCard("2h"));
        straight.add(cfactory.createCard("3c"));
        straight.add(cfactory.createCard("3d"));
        straight.add(cfactory.createCard("4d"));
        straight.add(cfactory.createCard("4s"));
        straight.add(cfactory.createCard("5s"));
        straight.add(cfactory.createCard("7h"));
        
        PokerHand hand = new PokerHand(straight);
        
        assertFalse(hand.isStraight());
	}
	
	
	public void test_isFlush() {
		CardFactory cfactory = new CardFactory();
        
        ArrayList<Card> flush = new ArrayList<Card>();
        flush.add(cfactory.createCard("2h"));
        flush.add(cfactory.createCard("3h"));

        flush.add(cfactory.createCard("4h"));
        flush.add(cfactory.createCard("5h"));
        flush.add(cfactory.createCard("6h"));
        flush.add(cfactory.createCard("2d"));
        flush.add(cfactory.createCard("3d"));
        
        PokerHand hand = new PokerHand(flush);
        
        assertTrue(hand.isFlush());
	}
	
	@Test
	public void test_isNotFlush() {
		CardFactory cfactory = new CardFactory();
        
        ArrayList<Card> flush = new ArrayList<Card>();
        flush.add(cfactory.createCard("2h"));
        flush.add(cfactory.createCard("3h"));

        flush.add(cfactory.createCard("4h"));
        flush.add(cfactory.createCard("5h"));
        flush.add(cfactory.createCard("6d"));
        flush.add(cfactory.createCard("6d"));
        flush.add(cfactory.createCard("3d"));
        
        PokerHand hand = new PokerHand(flush);
        
        assertFalse(hand.isFlush());
	}
}
