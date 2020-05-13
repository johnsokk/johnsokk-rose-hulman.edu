package ticketPackage;

import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdjustChargeJFrame extends JFrame {
	private HashMap cardMap;
	private String currentCardName;
	private HomePage homepage;
	private Boolean isPositive;

	public AdjustChargeJFrame(HashMap cardMap, String currentCardName, HomePage homepage, Boolean isPositive) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.isPositive = isPositive;
		// JFrame addChargeJFrame = new JFrame();
		// this.setTitle("Adding Charge");
		// String howMuchCharge = JOptionPane.showInputDialog("How much charge did you
		// add?");
		// int addedCharge = Integer.parseInt(howMuchCharge);
		if (this.isPositive == true) {
			String howMuchCharge = JOptionPane.showInputDialog("How much charge did you add?");
			int addedCharge = Integer.parseInt(howMuchCharge);
			cardMap.put(currentCardName, (int) cardMap.get(currentCardName) + addedCharge);

		} else {
			String howMuchCharge = JOptionPane.showInputDialog("How much charge did you spend?");
			int addedCharge = Integer.parseInt(howMuchCharge);
			cardMap.put(currentCardName, (int) cardMap.get(currentCardName) - addedCharge);

		}

		homepage.displayAllCards();
	}
}
