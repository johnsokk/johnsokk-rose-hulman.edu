package ticketPackage;

public class TransactionLog {

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
		return date;
	}

	public String getItem() {
		return item;
	}

	public int getAmount() {
		return amount;
	}

	public int getBalance() {
		return balance;
	}
	
}
