import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;



/**
 * 
 * @author dhaval
 * @brief Represent a hand that a player can have and what kind of hand it is. 
 */
public class PokerHand  {
	ArrayList<Card> cards;
	
	public PokerHand() {
		cards = new ArrayList<Card>();
	}
	
	public boolean add(String cardName) {
			CardFactory cfactory = new CardFactory();
			Card c = cfactory.createCard(cardName);
			if (cards  == null) {
				System.out.println("CARDS IS NULL");
				return false;
			}
			return cards.add(c);
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	
	public PokerHand(ArrayList<Card> hand) {
		this.cards = hand;
	}
	
	/**
	 * This function evaluates a set of cards and defines what type of hand it is. This is also where the priority of the hands will be set
	 * 
	 * @return
	 */
	public HAND_TYPE evaluateHandType() {
		HAND_TYPE retval = null;
		
        if (isOnePair()) {
            retval = HAND_TYPE.TWO_PAIR;
        }
        
        if (isThreeOfAKind()) {
            retval = HAND_TYPE.THREE_OF_A_KIND;
        }
        
        if (isStraight()) {
            retval = HAND_TYPE.STRAIGHT;
        }
        
        if (isFlush()) {
            retval = HAND_TYPE.FLUSH;
        } 
        
        if (isFourOfAKind()) {
            retval = HAND_TYPE.FOUR_OF_A_KIND;
        }
        
		return retval;
	}
	
	public void printHandType() {
		switch(evaluateHandType()) {
		case TWO_PAIR:
			System.out.println("TWO PAIR");
			break;
		case THREE_OF_A_KIND:
			System.out.println("THREE OF A KIND");
			break;
		case STRAIGHT:
			System.out.println("STRAIGHT");
			break;
		case FLUSH:
			System.out.println("FLUSH");
			break;
		case FOUR_OF_A_KIND:
			System.out.println("FOUR OF A KIND");
			break;
		}
	}
	
	// The Two Pair described is actually a One Pair
	public boolean isOnePair() {
		HashMap<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
    	
    	for(Card c: cards) {
    		if (numberCount.containsKey(c.getNumber())) {
    			int count = numberCount.get(c.getNumber());
    			numberCount.put(c.getNumber(), count + 1);
    		}
    		else
    			numberCount.put(c.getNumber(), 1);
    	}
    	
    	for(Integer i: numberCount.keySet()) {
    		if (numberCount.get(i) >= 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
	public boolean isThreeOfAKind() {
    	HashMap<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
    	
    	for(Card c: cards) {
    		if (numberCount.containsKey(c.getNumber())) {
    			int count = numberCount.get(c.getNumber());
    			numberCount.put(c.getNumber(), count + 1);
    		}
    		else
    			numberCount.put(c.getNumber(), 1);
    	}
    	

    	for(Integer i: numberCount.keySet()) {
    		if (numberCount.get(i) >= 3) {
    			return true;
    		}
    	}
    	return false;
 
    }
	
    public boolean isFourOfAKind() {
    	HashMap<Integer, Integer> numberCount = new HashMap<Integer, Integer>();
    	
    	for(Card c: cards) {
    		if (numberCount.containsKey(c.getNumber())) {
    			int count = numberCount.get(c.getNumber());
    			numberCount.put(c.getNumber(), count + 1);
    		}
    		else
    			numberCount.put(c.getNumber(), 1);
    	}
    	
    	for(Integer i: numberCount.keySet()) {
    		if (numberCount.get(i) >= 4) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean isStraight() {
        ArrayList<Integer> straightList = new ArrayList<Integer>();
        
        for(Card c: cards) {
        	straightList.add(c.getNumber());
        }
        
        // This is here because cards can be dealt in any sequence.
       Collections.sort(straightList);
       
       boolean retval = false;

       int minimum = straightList.get(0);
       ArrayList<Integer> expectedSequence = new ArrayList<Integer>();
       
       for(int i = minimum; i < minimum + 5; i++) {
    	   expectedSequence.add(i);
       }
       
       HashSet<Integer> givenSequence = new HashSet<Integer>();
       for(Integer i: straightList) {
    	   givenSequence.add(i);
       }
       
       if (givenSequence.containsAll(expectedSequence)) {
    	   return true;
       }
       else
    	   return false;
    }
    
    public boolean isFlush() {
    	HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
    	
    	for(Card c: cards) {
    		if (charCount.containsKey(c.getSuite())) {
    			int count = charCount.get(c.getSuite());
    			charCount.put(c.getSuite(), count + 1);
    		}
    		else
    			charCount.put(c.getSuite(), 1);

    	}
    	
    	for(Character ch: charCount.keySet()) {
    		if (charCount.get(ch) >= 5) {
    			return true;
    		}
    	}
    	return false;
    }
}
