package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
// Author Killian

public class TransactionHistoryListener implements ActionListener{
	private CardMenuJFrame cardMenuJFrame;
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private TransactionLinkedList searchLinkedList;

	// This class needs access to the JFrame in order to close the window
	public TransactionHistoryListener(CardMenuJFrame cardMenuJFrame, HashMap<String, Card> cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.searchLinkedList = this.cardMap.get(this.currentCardName).getTransactions();
	}

	public void actionPerformed(ActionEvent e) {
		// Closes the prior frame to declutter
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		// Creates a call for a new TransactionJFrame when button is pressed
		new TransactionJFrame(cardMenuJFrame, cardMap, currentCardName, homepage);
	}
}