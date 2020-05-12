package ticketPackage;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddChargeJFrame extends JFrame {
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;
	
	public AddChargeJFrame(HashMap cardMap, String currentCardName, HomePage homepage) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		//JFrame addChargeJFrame = new JFrame();
		//this.setTitle("Adding Charge");
		String howMuchCharge = JOptionPane.showInputDialog("How much charge did you add?");
		int addedCharge = Integer.parseInt(howMuchCharge);
		cardMap.put(currentCardName, (int)cardMap.get(currentCardName) + addedCharge);
		homepage.displayCard(currentCardName);
	}
}
