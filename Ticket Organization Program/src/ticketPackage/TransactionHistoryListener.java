
package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		new TransactionJFrame(cardMenuJFrame, cardMap, currentCardName, homepage);
		//AddChargeJFrame myCharge = new AddChargeJFrame(); 
		//myCharge.setTitle("Adding Charge");
	}
}