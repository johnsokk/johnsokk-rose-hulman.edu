package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardMenuJFrame extends JFrame {

	public CardMenuJFrame() {
		
		GridLayout cardMenuLayout = new GridLayout(4, 1);
		
		JPanel cardMenuPanel = new JPanel();
		
		JPanel addChargePanel = new JPanel();
		JPanel subtractChargePanel = new JPanel();
		JPanel transactionHistoryPanel = new JPanel();
		JPanel removeCardPanel = new JPanel();

		// Allows for our window to open
		this.setLayout(cardMenuLayout);
		
		JButton addChargeButton = new JButton("Add Charge");
		addChargeButton.addActionListener(new AddChargeListener(this));
		addChargePanel.add(addChargeButton);
		this.add(addChargePanel);
		
		JButton subtractChargeButton = new JButton("Subtract Charge");
		//subtractChargeButton.addActionListener(new subtractChargeListener(this));
		subtractChargePanel.add(subtractChargeButton);
		this.add(subtractChargePanel);
		
		JButton transactionHistoryButton = new JButton("View Transaction History");
		//transactionHistoryPanel.addActionListener(new TransactionHistoryListener(this));
		transactionHistoryPanel.add(transactionHistoryButton);
		this.add(transactionHistoryPanel);
		
		JButton removeCardButton = new JButton("Remove Card");
		//addCardButton.addActionListener(new removeCardButtonListener(this));
		removeCardPanel.add(removeCardButton);
		this.add(removeCardPanel);
		
		
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}
	
}
