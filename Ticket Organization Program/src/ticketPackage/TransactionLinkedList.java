package ticketPackage;

import java.util.ArrayList;
import java.util.LinkedList;

public class TransactionLinkedList extends LinkedList<TransactionLog> {
	
	public Object[][] transactionLogToTableData() {
		Object[][] transactionData = new Object[this.size()][4];
		for(int k = 0; k < this.size(); k++) {
			Object[] newTransactionData = new Object[4];
			newTransactionData[0] = this.get(k).getDate();
			newTransactionData[1] = this.get(k).getItem();
			newTransactionData[2] = this.get(k).getAmount();
			newTransactionData[3] = this.get(k).getBalance();
			transactionData[k] = newTransactionData;
		}
		return transactionData;
	}

}
