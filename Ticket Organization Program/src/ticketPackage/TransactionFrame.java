package ticketPackage;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TransactionFrame extends JFrame {
	private Integer hcbalance;
	private String str;
	private String expDate;

	public TransactionFrame(Card card) {
		this.hcbalance = hcbalance;
		this.str = str;
		this.expDate = expDate;
		GridLayout transactionlayout = new GridLayout();
		JPanel transactionPanel = new JPanel();
		this.setLayout(transactionlayout);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public void addTransaction() {
		System.out.println("Made it!");
	}

}
