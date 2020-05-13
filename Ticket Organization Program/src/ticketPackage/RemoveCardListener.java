
package ticketPackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
		cardMenuJFrame.setVisible(false);
		cardMenuJFrame.dispose();
		cardMap.remove(currentCardName);
		homepage.displayAllCards();
		//new AdjustChargeJFrame(cardMap, currentCardName, homepage); 
		//AddChargeJFrame myCharge = new AddChargeJFrame(); 
		//myCharge.setTitle("Adding Charge");
	}
}