
public class Card {
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setNumber(char face) {
		switch(face) {
		case 'a':
			this.number = 1;
			break;
		case 'j':
			this.number = 11;
			break;
		case 'q':
			this.number = 12;
			break;
		case 'k':
			this.number = 13;
			break;
		}
	}
	
	public char getSuite() {
		return suite;
	}
	
	public void setSuite(char suite) {
		this.suite = suite;
	}
	
	public boolean equals(Card c) {
		if(this.getNumber() == c.getNumber() && this.getSuite() == c.getSuite())
			return true;
		else
			return false;
	}
	
	public String toString() {
		return this.getNumber() + " " + this.getSuite();
	}
	
	int number;
	char suite;
}
