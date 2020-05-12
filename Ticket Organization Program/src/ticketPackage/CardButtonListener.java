package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CardButtonListener implements ActionListener {
	//private AddCardJFrame addCardJFrame;
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;
	
	public CardButtonListener(HashMap cardMap, String currentCardName, HomePage homepage) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		//this.addCardJFrame = addCardJFrame;
	}

	public void actionPerformed(ActionEvent e) {
		//addCardJFrame.addTransaction();
		//addCardJFrame.setVisible(true);
		//addCardJFrame.dispose();
		new CardMenuJFrame(cardMap, currentCardName, homepage);
		System.out.println("Hi");
	}
}
