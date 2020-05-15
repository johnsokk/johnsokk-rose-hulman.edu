package ticketPackage;

import java.awt.GridLayout;

import javax.swing.JTextField;

public class Card {
	private String str; 
	private int hcbalance; 
	private String expDate;
	private TransactionLinkedList transactions;
	
	public Card(String str, Integer hcbalance, String expDate) {
		this.str = str;
		this.hcbalance = hcbalance;
		this.expDate = expDate; 
		this.transactions = new TransactionLinkedList();
		
	}
	
	public Card() {
		this.str = "Card Name";
		this.hcbalance = 0;
		this.expDate = "05/15/2020";
	}
	
		public String getstr() {
			return str;
		}
		public int gethcbalance() {
			return hcbalance;
		}
		public String expDate() {
			return expDate;
		}
		
		public void addBalance(int amount) {
			hcbalance += amount;
		}
		public void subtractBalance(int amount) {
			hcbalance -= amount;
		}
		
		public TransactionLinkedList getTransactions() {
			return this.transactions;
		}
}

