package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
// Author Killian

public class CardButtonListener implements ActionListener {
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private TransactionLinkedList searchLinkedList;
	
	public CardButtonListener(HashMap<String, Card> cardMap, String currentCardName, HomePage homepage) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.searchLinkedList = this.cardMap.get(this.currentCardName).getTransactions();
	}

	public void actionPerformed(ActionEvent e) {
		// This calls to create/open a new Card Menu window when a Card button is pressed 
		new CardMenuJFrame(cardMap, currentCardName, homepage);	
	}
}
