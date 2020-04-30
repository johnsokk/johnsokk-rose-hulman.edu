package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

// Author: Braden

public class AddCardButtonListener implements ActionListener {
	private AddCardJFrame addCardJFrame;

	// This class needs access to the JFrame in order to close the window

	public AddCardButtonListener(AddCardJFrame addCardJFrame) {
		this.addCardJFrame = addCardJFrame;
	}

	public void actionPerformed(ActionEvent e) {

//		JPanel newCardPanel = new JPanel();
//		JLabel cardName = new JLabel("Test");
//		newCardPanel.add(cardName);
		// System.out.println(str);
		// This is just a print statement so that we can verify our button is
		// functional.
		addCardJFrame.addCardToHome();

		// this.homePageJFrame.add(newCardPanel);
		// addCardJFrame.dispose();
		addCardJFrame.setVisible(false);
		addCardJFrame.dispose();
		// This closes the Add Card Window when the button is pressed.

		// need a hashmap with key being name of each card, card being card object, have
		// hashmap being passed
		// around to every object; might be worth call a method in Addcardjframe called
		// newcard
		// have a card object that holds balance, name, expiration date, date added,
		// etc. Make them fields in card object
		// when you hit button to create a new card,
	}
}
