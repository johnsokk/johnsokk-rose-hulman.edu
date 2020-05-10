package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardButtonListener implements ActionListener {
	//private AddCardJFrame addCardJFrame;

	public CardButtonListener() {
		//this.addCardJFrame = addCardJFrame;

	}

	public void actionPerformed(ActionEvent e) {
		//addCardJFrame.addTransaction();
		//addCardJFrame.setVisible(true);
		//addCardJFrame.dispose();
		new CardMenuJFrame();
		
		System.out.println("Hi");

	}
}
