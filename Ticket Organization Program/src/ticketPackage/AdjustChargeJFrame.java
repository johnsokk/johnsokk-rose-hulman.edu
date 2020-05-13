package ticketPackage;

import java.util.Date;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AdjustChargeJFrame extends JFrame {
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private Boolean isPositive;

	public AdjustChargeJFrame(HashMap<String, Card> cardMap, String currentCardName, HomePage homepage, Boolean isPositive) {
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
			cardMap.get(currentCardName).addBalance(addedCharge);
			TransactionLog newLog = new TransactionLog((new Date()).toString(), "dummy variable", addedCharge, cardMap.get(currentCardName).gethcbalance());
			cardMap.get(currentCardName).getTransactions().add(newLog);

		} else {
			String howMuchCharge = JOptionPane.showInputDialog("How much charge did you spend?");
			int addedCharge = Integer.parseInt(howMuchCharge);
			cardMap.get(currentCardName).subtractBalance(addedCharge);
			TransactionLog newLog = new TransactionLog((new Date()).toString(), "dummy variable", -1*addedCharge, cardMap.get(currentCardName).gethcbalance());
			cardMap.get(currentCardName).getTransactions().add(newLog);

		}

		homepage.displayAllCards();
	}
}
