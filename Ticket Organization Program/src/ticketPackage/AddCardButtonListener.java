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
		addCardJFrame.addCardToHome();
		addCardJFrame.setVisible(false);
		addCardJFrame.dispose();
		// This closes the Add Card Window when the button is pressed.
	}
}
