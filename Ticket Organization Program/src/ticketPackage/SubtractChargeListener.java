package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
// Author Braden

public class SubtractChargeListener implements ActionListener{
	private CardMenuJFrame cardMenuJFrame;
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;
	
	// This class needs access to the JFrame in order to close the window
	public SubtractChargeListener(CardMenuJFrame cardMenuJFrame, HashMap cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
	}

	public void actionPerformed(ActionEvent e) {
		// The false boolean makes sure that charge gets subtracted instead of added
		Boolean isPositive = false; 
		// Closes the previous window to declutter
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		// Creates a call to the adjust charge JFrame to open
		new AdjustChargeJFrame(cardMap, currentCardName, homepage,isPositive); 

	}
}
