package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
// Author Braden

public class AddChargeListener implements ActionListener{
	private CardMenuJFrame cardMenuJFrame;
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;

	// This class needs access to the JFrame in order to close the window
	public AddChargeListener(CardMenuJFrame cardMenuJFrame, HashMap cardMap, String currentCardName,
			HomePage homepage) {
		this.cardMenuJFrame = cardMenuJFrame;
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
	}

	public void actionPerformed(ActionEvent e) {
		// Defaults to adding charge (true) When false, it subtracts charge
		Boolean isPositive = true; 
		// Closes the previous window to declutter
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		// Calls to create a new JFrame to adjust charge
		new AdjustChargeJFrame(cardMap, currentCardName, homepage, isPositive); 
	}
}
