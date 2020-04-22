package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddCardButtonListener implements ActionListener {
	private AddCardJFrame addCardJFrame;
	
	public AddCardButtonListener(AddCardJFrame addCardJFrame) {
		this.addCardJFrame = addCardJFrame;
	}
	public void actionPerformed(ActionEvent e) {
		
//		JPanel newCardPanel = new JPanel();
//		JLabel cardName = new JLabel("Test");
//		newCardPanel.add(cardName);
		System.out.println("Testing");
		//this.homePageJFrame.add(newCardPanel);
		//addCardJFrame.dispose();
		addCardJFrame.setVisible(false);
		addCardJFrame.dispose();
		//need a hashmap with key being name of each card, card being card object, have hashmap being passed
		//around to every object; might be worth call a method in Addcardjframe called newcard
		//have a card object that holds balance, name, expiration date, date added, etc. Make them fields in card object
		//when you hit button to create a new card, 
	}
}
