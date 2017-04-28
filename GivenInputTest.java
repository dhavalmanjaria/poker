import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;

public class GivenInputTest {

	@Test
	public void testInput1() {
		CardFactory cfactory = new CardFactory();
		
		ArrayList<Card> input1 = new ArrayList<Card>();
		input1.add(cfactory.createCard("7s"));
		input1.add(cfactory.createCard("kd"));
		input1.add(cfactory.createCard("7h"));
		input1.add(cfactory.createCard("4d"));
		input1.add(cfactory.createCard("6c"));
		input1.add(cfactory.createCard("qh"));
		input1.add(cfactory.createCard("7c"));
		
		PokerHand hand = new PokerHand(input1);
		
		assertEquals(HAND_TYPE.THREE_OF_A_KIND, hand.evaluateHandType());
	}
	
	@Test
	public void testInput2() {
		CardFactory cfactory = new CardFactory();
		
        ArrayList<Card> input2 = new ArrayList<Card>();
        input2.add(cfactory.createCard("7h"));
        input2.add(cfactory.createCard("4d"));
        input2.add(cfactory.createCard("6s"));
        input2.add(cfactory.createCard("qs"));
        input2.add(cfactory.createCard("kh"));
        input2.add(cfactory.createCard("5c"));
        input2.add(cfactory.createCard("8h"));
        
		PokerHand hand = new PokerHand(input2);
		hand.printHandType();
		assertEquals(HAND_TYPE.STRAIGHT, hand.evaluateHandType());
	}
	
	@Test
	public void testInput3() {
		CardFactory cfactory = new CardFactory();
		
        ArrayList<Card> input3 = new ArrayList<Card>();
        input3.add(cfactory.createCard("2s"));
        input3.add(cfactory.createCard("kd"));
        input3.add(cfactory.createCard("2h"));
        input3.add(cfactory.createCard("as"));
        input3.add(cfactory.createCard("2d"));
        input3.add(cfactory.createCard("6h"));
        input3.add(cfactory.createCard("2c"));
        
        PokerHand hand = new PokerHand(input3);
        hand.printHandType();
        assertEquals(HAND_TYPE.FOUR_OF_A_KIND, hand.evaluateHandType());
	}

}
