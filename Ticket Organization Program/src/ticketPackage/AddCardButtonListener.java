package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AddCardButtonListener implements ActionListener {
	private JFrame addCardJFrame;
	
	public AddCardButtonListener(JFrame addCardJFrame) {
		this.addCardJFrame = addCardJFrame;
	}
	public void actionPerformed(ActionEvent e) {
		
		JPanel newCardPanel = new JPanel();
		JLabel cardName = new JLabel("Test");
		newCardPanel.add(cardName);
		System.out.println("Testing");
		//this.homePageJFrame.add(newCardPanel);
		addCardJFrame.dispose();
		addCardJFrame.dispatchEvent(new WindowEvent(addCardJFrame, WindowEvent.WINDOW_CLOSING));
	}
}
