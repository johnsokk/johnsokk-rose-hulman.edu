package ticketPackage;
// Author Kaia

public class Card {
	private String str; 
	private int hcbalance; 
	private String expDate;
	private TransactionLinkedList transactions;
	
	public Card(String str, Integer hcbalance, String expDate) {
		this.str = str;
		this.hcbalance = hcbalance;
		this.expDate = expDate; 
		// Creates a call for a new class where a Linked List for transactions is created
		this.transactions = new TransactionLinkedList();
		
	}
	
	public Card() {
		// When Card is called without any parameters, these values get set in order to run JUnit testing
		this.str = "Card Name";
		this.hcbalance = 0;
		this.expDate = "05/15/2020";
	}
	
		public String getstr() {
			// Method used to get a card's string
			return str;
		}
		public int gethcbalance() {
			// Method used to get a card's balance
			return hcbalance;
		}
		public String expDate() {
			// Method used to get a card's expiration date
			return expDate;
		}
		
		public void addBalance(int amount) {
			// Method used to add charge to the Card's balance
			hcbalance += amount;
		}
		public void subtractBalance(int amount) {
			// Method used to subtract charge from the Card's balance
			hcbalance -= amount;
		}
		
		public TransactionLinkedList getTransactions() {
			// Method used to get the Linked List of transactions
			return this.transactions;
		}
}

