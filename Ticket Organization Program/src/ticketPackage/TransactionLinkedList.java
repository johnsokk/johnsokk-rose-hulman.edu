package ticketPackage;
import java.util.LinkedList;
// Author Killian

public class TransactionLinkedList extends LinkedList<TransactionLog> {
	
	public Object[][] transactionLogToTableData() {
		// Creates a new array of size (number of transactions) x 4
		Object[][] transactionData = new Object[this.size()][4];
		// Iterates through a loop to add transaction information to the array
		for(int k = 0; k < this.size(); k++) {
			// Creates an arrayList to store individual transaction information
			Object[] newTransactionData = new Object[4];
			// Adds the necessary information to the arrayList
			newTransactionData[0] = this.get(k).getDate();
			newTransactionData[1] = this.get(k).getItem();
			newTransactionData[2] = this.get(k).getAmount();
			newTransactionData[3] = this.get(k).getBalance();
			// Adds the arrayList to the array of all the transactions
			transactionData[k] = newTransactionData;
		}
		// Spits out the array with the newly-added information
		return transactionData;
	}
}
