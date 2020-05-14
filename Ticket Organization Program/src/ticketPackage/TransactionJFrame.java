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

		// GridLayout transactionlayout = new GridLayout(2,1);
		JPanel transactionPanel = new JPanel();
		// this.setLayout(transactionlayout);
		JButton searchButton = new JButton("Search Transactions");
		JButton returnToHome = new JButton("Return to Home");

		class ReturnToHomeListener implements ActionListener {
			private JFrame transactionHistoryJFrame;

			public ReturnToHomeListener(JFrame transactionHistoryJFrame) {
				this.transactionHistoryJFrame = transactionHistoryJFrame;
			}

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				this.transactionHistoryJFrame.setVisible(false);
				this.transactionHistoryJFrame.dispose();
			}

		}
		returnToHome.addActionListener(new ReturnToHomeListener(this));
		JButton printToFile = new JButton("Print to File");
		JPanel buttonPanel = new JPanel();
		printToFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TransactionLogWriter();
			}
		});

		String[] columnNames = { "Date", "Item", "Amount", "Balance" };
		Object[][] transactionData = cardMap.get(currentCardName).getTransactions().transactionLogToTableData();
		JTable transactionTable = new JTable(transactionData, columnNames);
		transactionTable.setBounds(40, 40, 40, 40);
		this.add(new JScrollPane(transactionTable));

		this.setTitle(" Transaction History For: " + currentCardName);
		buttonPanel.add(searchButton);
		buttonPanel.add(returnToHome);
		buttonPanel.add(printToFile);
		this.add(buttonPanel, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public void addTransaction() {
		System.out.println("Made it!");
	}

}
