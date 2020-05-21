package ticketPackage;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

//Author Kaia

public class CardMenuJFrame extends JFrame {
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private TransactionLinkedList searchLinkedList;
	
	public CardMenuJFrame(HashMap<String, Card> cardMap, String currentCardName, HomePage homepage) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.searchLinkedList = this.cardMap.get(this.currentCardName).getTransactions();
		// Sets the title of the window to remind the user which card was clicked
		this.setTitle(currentCardName + " Menu");
		// Sets the layout of the JFrame to vertical in one column with 4 rows
		GridLayout cardMenuLayout = new GridLayout(4, 1);
		// Makes 4 new panels to add the each button to
		JPanel cardMenuPanel = new JPanel();
		JPanel addChargePanel = new JPanel();
		JPanel subtractChargePanel = new JPanel();
		JPanel transactionHistoryPanel = new JPanel();
		JPanel removeCardPanel = new JPanel();
		// Sets the layout created earlier to the frame
		this.setLayout(cardMenuLayout);
		// Creates a button to add charge to the card and adds a listener
		JButton addChargeButton = new JButton("Add Charge");
		addChargeButton.addActionListener(new AddChargeListener(this, cardMap, currentCardName, homepage));
		// Adds the button to the panel
		addChargePanel.add(addChargeButton);
		// Adds the panel to the frame
		this.add(addChargePanel);
		// Creates a button to subtract charge to the card and adds a listener
		JButton subtractChargeButton = new JButton("Subtract Charge");
		subtractChargeButton.addActionListener(new SubtractChargeListener(this, cardMap, currentCardName, homepage));
		// Adds the button to the panel
		subtractChargePanel.add(subtractChargeButton);
		// Adds the panel to the frame
		this.add(subtractChargePanel);
		// Creates a button to view transaction history of the card and adds a listener
		JButton transactionHistoryButton = new JButton("View Transaction History");
		transactionHistoryButton.addActionListener(new TransactionHistoryListener(this, cardMap, currentCardName, homepage));
		// Adds the button to the panel
		transactionHistoryPanel.add(transactionHistoryButton);
		// Adds the panel to the frame
		this.add(transactionHistoryPanel);
		// Creates a button to remove the card from the program and adds a listener
		JButton removeCardButton = new JButton("Remove Card");
		removeCardButton.addActionListener(new RemoveCardListener(this,cardMap, currentCardName, homepage));
		// Adds the button to the panel
		removeCardPanel.add(removeCardButton);
		// Adds the panel to the frame
		this.add(removeCardPanel);
		// Does the necessary stuff to get the frame to cooperate
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}	
}
