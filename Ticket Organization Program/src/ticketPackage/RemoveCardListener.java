package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;
// Author Braden

public class RemoveCardListener implements ActionListener{
	private CardMenuJFrame cardMenuJFrame;
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;
	
	// This class needs access to the JFrame in order to close the window
	public RemoveCardListener(CardMenuJFrame cardMenuJFrame, HashMap cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
	}

	public void actionPerformed(ActionEvent e) {
		// This closes the previous window to declutter
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		// This is a call to create a new DeleteCardConfirmationJFrame
		new DeleteCardConfirmationJFrame(cardMap, homepage, currentCardName);
	}
}