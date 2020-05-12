package ticketPackage;

import java.awt.GridLayout;

import javax.swing.JTextField;

public class Card {
	private String str; 
	private int hcbalance; 
	private String expDate; 
	
	public Card(String str, Integer hcbalance, String expDate) {
		this.str = str;
		this.hcbalance = hcbalance;
		this.expDate = expDate; 
		
		
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
}

