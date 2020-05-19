package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
		Boolean isPositive = false; 
		
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		new AdjustChargeJFrame(cardMap, currentCardName, homepage,isPositive); 

	}
}
