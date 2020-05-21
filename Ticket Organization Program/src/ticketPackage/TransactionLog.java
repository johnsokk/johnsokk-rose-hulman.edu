package ticketPackage;
public class TransactionLog {
// Author Killian
	
	private String date;
	private String item;
	private int amount;
	private int balance;

	public TransactionLog(String date, String item, int amount, int balance) {
		this.date = date;
		this.item = item;
		this.amount = amount;
		this.balance = balance;
		
	}
	public String getDate() {
		// Returns the date
		return date;
	}
	public String getItem() {
		// Returns the item
		return item;
	}
	public int getAmount() {
		// Returns the amount
		return amount;
	}
	public int getBalance() {
		// Returns the balance
		return balance;
	}
}
