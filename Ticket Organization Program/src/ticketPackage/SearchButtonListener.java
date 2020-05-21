package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;
// Author Kaia

public class SearchButtonListener implements ActionListener {
	private TransactionLinkedList searchLinkedList;
	private JTextField searchBox;
	private SearchJFrame searchJFrame;

	public SearchButtonListener(TransactionLinkedList searchLinkedList, JTextField searchBox, SearchJFrame searchJFrame) {
		this.searchLinkedList = searchLinkedList;
		this.searchBox = searchBox;
		this.searchJFrame = searchJFrame;
	}
	public void actionPerformed(ActionEvent e) {
		// Creates a new 2D array of transactions
		Object[][] searchArray = searchLinkedList.transactionLogToTableData();
		// Checks to see if the input search item is found
		boolean isFound = false;
		// Loops through the Linked List to try to find the keyword
		for (int i = 0; i < this.searchLinkedList.size(); i++) {
			// If the keyword is found, change the boolean to true
			if (searchArray[i][1].toString().contains(searchBox.getText())) {
				System.out.println(searchArray[i][0].toString() + " " + searchArray[i][1].toString() + " " + searchArray[i][2].toString());
				isFound = true;
			}
		}
		// Checks to see if the keyword was found
		if (isFound == false) {
			// Alerts the user that nothing was found
			System.out.println("Key word not found.");
		}
		// Closes the current search window to declutter
		this.searchJFrame.dispose();
		this.searchJFrame.setVisible(false);
	}
}
