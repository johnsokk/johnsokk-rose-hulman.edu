package ticketPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddChargeListener implements ActionListener{
	private CardMenuJFrame cardMenuJFrame;

	// This class needs access to the JFrame in order to close the window

	public AddChargeListener(CardMenuJFrame cardMenuJFrame) {
		this.cardMenuJFrame = cardMenuJFrame;
	}

	public void actionPerformed(ActionEvent e) {
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		new AddChargeJFrame();

	}
}
