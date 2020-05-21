package ticketPackage;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
// Author Kaia

public class TransactionJFrame extends JFrame {
	private Integer hcbalance;
	private String str;
	private String expDate;
	private CardMenuJFrame cardMenuJFrame;
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private TransactionLinkedList searchLinkedList;

	public TransactionJFrame(CardMenuJFrame cardMenuJFrame, HashMap<String, Card> cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.searchLinkedList = this.cardMap.get(this.currentCardName).getTransactions();
		// Creates new panels to be added to the JFrame later
		JPanel transactionPanel = new JPanel();
		JButton searchButton = new JButton("Search Transactions");
		JButton returnToHome = new JButton("Return to Home");

		class ReturnToHomeListener implements ActionListener {
			private JFrame transactionHistoryJFrame;

			public ReturnToHomeListener(JFrame transactionHistoryJFrame) {
				this.transactionHistoryJFrame = transactionHistoryJFrame;
			}

			public void actionPerformed(ActionEvent e) {
				// Closes the current window to declutter when button is pressed
				this.transactionHistoryJFrame.setVisible(false);
				this.transactionHistoryJFrame.dispose();
			}
		}
		// Adds a listener to the home button
		returnToHome.addActionListener(new ReturnToHomeListener(this));
		// Makes a new button and panel
		JButton printToFile = new JButton("Print to File");
		JPanel buttonPanel = new JPanel();
		// Adds a new listener to the print to file button
		printToFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Makes a call to a new class to the TransactionLogWriter class
				TransactionLogWriter writer = new TransactionLogWriter();
				// Calls a method that gets the transactions and writes them to a file
				writer.writetransactions(cardMap.get(currentCardName).getTransactions());
			}
		});
		class SearchButtonListener implements ActionListener {
			private TransactionLinkedList searchLinkedList;

			public SearchButtonListener(TransactionLinkedList searchLinkedList) {
				this.searchLinkedList = searchLinkedList;
			}

			public void actionPerformed(ActionEvent e) {
				// Creates a new call to the SearchJFrame class when button is pressed
				new SearchJFrame(searchLinkedList);
			}
		}
		// Adds a listener to the Search Button
		searchButton.addActionListener(new SearchButtonListener(this.searchLinkedList));
		// Creates an arrayList with column headings to display at the top of the JTable
		// for the transaction history
		String[] columnNames = { "Date", "Item", "Amount", "Balance" };
		// Creates an array of transactions to display in the transaction History JTable
		Object[][] transactionData = cardMap.get(currentCardName).getTransactions().transactionLogToTableData();
		// Creates a new JTable
		JTable transactionTable = new JTable(transactionData, columnNames);
		// Sets the dimensions of the table
		transactionTable.setBounds(40, 40, 40, 40);
		// Gets JTable to display correctly and be scrollable
		this.add(new JScrollPane(transactionTable));
		// Sets title of JFrame to remind user which card's transactions are being
		// viewed
		this.setTitle(" Transaction History For: " + currentCardName);
		// Adds buttons to the panel
		buttonPanel.add(searchButton);
		buttonPanel.add(returnToHome);
		buttonPanel.add(printToFile);
		// Adds panel to the frame
		this.add(buttonPanel, BorderLayout.SOUTH);
		// Does necessary stuff to get the JFrame to display/behave properly
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
