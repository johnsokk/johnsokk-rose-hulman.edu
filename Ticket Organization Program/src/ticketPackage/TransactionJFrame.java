package ticketPackage;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TransactionJFrame extends JFrame {
	private Integer hcbalance;
	private String str;
	private String expDate;
	private CardMenuJFrame cardMenuJFrame;
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;

	public TransactionJFrame(CardMenuJFrame cardMenuJFrame, HashMap<String, Card> cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;

		GridLayout transactionlayout = new GridLayout();
		JPanel transactionPanel = new JPanel();
		this.setLayout(transactionlayout);
		JButton searchButton = new JButton("Search Transactions");
		JButton returnToHome = new JButton("Return to Home");
		JButton printToFile = new JButton("Print to File");

		String[] columnNames = { "Date", "Item", "Amount", "Balance" };
		Object[][] transactionData = cardMap.get(currentCardName).getTransactions().transactionLogToTableData();
		JTable transactionTable = new JTable(transactionData, columnNames);
		transactionTable.setBounds(30, 40, 200, 300);
		this.add(new JScrollPane(transactionTable));


		this.setTitle(" Transaction History For: " + currentCardName);
		this.add(searchButton);
		this.add(returnToHome);
		this.add(printToFile);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public void addTransaction() {
		System.out.println("Made it!");
	}

}
