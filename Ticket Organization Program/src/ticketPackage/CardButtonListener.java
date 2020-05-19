package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CardButtonListener implements ActionListener {
	//private AddCardJFrame addCardJFrame;
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
		new CardMenuJFrame(cardMap, currentCardName, homepage);
		System.out.println("Hi " + currentCardName);
	
	}
}
