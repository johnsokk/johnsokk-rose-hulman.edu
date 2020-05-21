package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Author Braden

public class AddCardButtonListener implements ActionListener {
	private AddCardJFrame addCardJFrame;

	// This class needs access to the JFrame in order to close the window
	public AddCardButtonListener(AddCardJFrame addCardJFrame) {
		this.addCardJFrame = addCardJFrame;
	}

	public void actionPerformed(ActionEvent e) {
		// This calls a method in addCardJFrame to create a new card and add it to the
		// hashMap. It also adds the Card
		// to the homePage.
		try {
			addCardJFrame.addCardToHome();
		} catch (NumberFormatException exception) {
			// If the user inputs any character that is not an integer, it will throw this message.
			JOptionPane.showMessageDialog(null,
					"Please input a number without decimals or commas that is less than ten digits.");
			return;
		}
		// Necessary stuff to get the previous window to close
		addCardJFrame.setVisible(false);
		addCardJFrame.dispose();
		// This closes the Add Card Window when the button is pressed.
	}
}
