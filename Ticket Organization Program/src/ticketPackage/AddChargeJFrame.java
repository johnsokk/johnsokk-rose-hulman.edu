package ticketPackage;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AddChargeJFrame extends JFrame {
	public void addChargeJFrame() {

		// JFrame addChargeJFrame = new JFrame();
		this.setTitle("Adding Charge");
		String howMuchCharge = JOptionPane.showInputDialog("How much charge did you add?");
		int addedCharge = Integer.parseInt(howMuchCharge);
		
		System.out.println("HELP");

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}
}
