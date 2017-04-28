import java.util.ArrayList;
import java.util.Collections;

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
	
	// 
	public boolean isOnePair() {
		ArrayList<Integer> twoPairList = new ArrayList<Integer>();
		for(Card c: cards) {
			if (twoPairList.contains(c.getNumber()))
				return true;
			else
				twoPairList.add(c.getNumber());
		}
		return false;
	}
	
	public boolean isThreeOfAKind() {
        ArrayList<Integer> threeKindList = new ArrayList<Integer>();
        
        int cardNumberCount = 1;
        
        for(Card c: cards) {
            if(threeKindList.contains(c.getNumber())) {
                cardNumberCount++;
                if (cardNumberCount > 2) {
                    return true;
                }
            }

            threeKindList.add(c.getNumber());
        }
        return false;
    }
    
    public boolean isFourOfAKind() {
        ArrayList<Integer> fourKindList = new ArrayList<Integer>();
        
        int cardNumberCount = 1;
        
        for(Card c: cards) {
            if(fourKindList.contains(c.getNumber())) {
                cardNumberCount++;
                if (cardNumberCount > 3) {
                    return true;
                }
            }
            fourKindList.add(c.getNumber());
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

       int seq_count = 1;
       for(int i = 0; i < straightList.size(); i++) {
    	  // System.out.println((straightList.get(i) - straightList.get(i - )) == 1);
    	   if (i > 0) {
    		   if ((straightList.get(i) - straightList.get(i - 1)) == 1) {
    			   seq_count++;
    			   if(seq_count > 4) {
    				   retval = true;
    			   }
    		   } 
    		   else {
    			   seq_count = 1;
    		   }
    			   
    	   }
       }
       return retval;
    }
    
    public boolean isFlush() {
    	ArrayList<Character> flushList = new ArrayList<Character>();
    	
    	for(Card c: cards) {
    		flushList.add(c.getSuite());
    		if(!flushList.contains(c.getSuite())) {
    			System.out.println(c.getSuite());
    			
    		}
    			
    	}
    	return true;
    }
}
