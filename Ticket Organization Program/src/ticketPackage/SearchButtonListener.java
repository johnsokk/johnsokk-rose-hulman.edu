package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JTextField;

public class SearchButtonListener implements ActionListener {
	private TransactionLinkedList searchLinkedList;
	private JTextField searchBox;
	private SearchJFrame searchJFrame;
	// private AddCardJFrame addCardJFrame;

	public SearchButtonListener(TransactionLinkedList searchLinkedList, JTextField searchBox, SearchJFrame searchJFrame) {
		this.searchLinkedList = searchLinkedList;
		this.searchBox = searchBox;
		this.searchJFrame = searchJFrame;
	}

	public void actionPerformed(ActionEvent e) {

		Object[][] searchArray = searchLinkedList.transactionLogToTableData();
		boolean isFound = false;
		for (int i = 0; i < this.searchLinkedList.size(); i++) {
			if (searchArray[i][1].toString().contains(searchBox.getText())) {
				System.out.println(searchArray[i][0].toString() + " " + searchArray[i][1].toString() + " " + searchArray[i][2].toString());
				isFound = true;

			}
		}
		if (isFound == false) {
			System.out.println("Key word not found.");
		}
		this.searchJFrame.dispose();
		this.searchJFrame.setVisible(false);
	}
}
