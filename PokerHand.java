import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

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
	
	enum HAND_TYPE {
		TWO_PAIR,
		THREE_OF_A_KIND,
		STRAIGHT,
		FLUSH,
		FOUR_OF_A_KIND
	};
	
	public PokerHand(ArrayList<Card> hand) {
		this.cards = hand;
	}
	
	// The TwoPair described is actually a One Pair
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

       int seq_count = 0;
       for(int i = 0; i < straightList.size(); i++) {
    	  // System.out.println((straightList.get(i) - straightList.get(i - )) == 1);
    	   if (i > 0) {
    		   
    		   if ((straightList.get(i) - straightList.get(i - 1)) <= 1) {
    			   seq_count++;
				   if(seq_count > 4) {
    				   retval = true;
    			   }
    		   } 
    		   else {
    			   seq_count = 0;
    			   retval = false;
    		   }

    	   }
       }
       return retval;
    }
    
    public boolean isFlush() {
    	HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
    	
    	for(Card c: cards) {
    		if (charCount.containsKey(c.getSuite())) {
    			int count = charCount.get(c.getSuite());
    			charCount.put(c.getSuite(), count + 1);
    		}
    		else
    			charCount.put(c.getSuite(), 0);
    	}
    	
    	for(Character ch: charCount.keySet()) {
    		if (charCount.get(ch) >= 5) {
    			return true;
    		}
    		else {
    			return false;
    		}
    	}
    	return false;
    }
}
