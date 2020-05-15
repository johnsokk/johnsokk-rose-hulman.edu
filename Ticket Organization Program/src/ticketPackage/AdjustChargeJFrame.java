package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AdjustChargeJFrame extends JFrame {
	private HashMap<String, Card> cardMap;
	private String currentCardName;
	private HomePage homepage;
	private Boolean isPositive;
	private JTextField chargeAmount;
	private JTextField transactionDescription;

	public AdjustChargeJFrame(HashMap<String, Card> cardMap, String currentCardName, HomePage homepage,
			Boolean isPositive) {
		this.cardMap = cardMap;
		this.currentCardName = currentCardName;
		this.homepage = homepage;
		this.isPositive = isPositive;
		// JFrame addChargeJFrame = new JFrame();
		// this.setTitle("Adding Charge");
		// String howMuchCharge = JOptionPane.showInputDialog("How much charge did you
		// add?");
		// int addedCharge = Integer.parseInt(howMuchCharge);
		GridLayout myLayout = new GridLayout(3, 1);
		JPanel adjustChargeTopPanel = new JPanel();
		JPanel adjustChargeMiddlePanel = new JPanel();
		JPanel adjustChargeBottomPanel = new JPanel();

		this.setLayout(myLayout);

		if (this.isPositive == true) {

			// JLabel chargeLabel = new JLabel("How much charge did you add?");

			String howMuchCharge = JOptionPane.showInputDialog("How much charge did you add?");
			int addedCharge = Integer.parseInt(howMuchCharge);
			cardMap.get(currentCardName).addBalance(addedCharge);
			TransactionLog newLog = new TransactionLog((new Date()).toString(), "Deposit", addedCharge,
					cardMap.get(currentCardName).gethcbalance());
			cardMap.get(currentCardName).getTransactions().add(newLog);
			homepage.displayAllCards();

		} else {
			JLabel chargeLabel = new JLabel("How much charge did you spend?          ¥");
			JLabel itemLabel = new JLabel("Please provide a transaction description:");
			chargeAmount = new JTextField("");
			transactionDescription = new JTextField("");
			adjustChargeTopPanel.add(chargeLabel, BorderLayout.NORTH);
			adjustChargeMiddlePanel.add(itemLabel, BorderLayout.NORTH);
			adjustChargeTopPanel.add(chargeAmount, BorderLayout.CENTER);
			adjustChargeMiddlePanel.add(transactionDescription, BorderLayout.CENTER);
			chargeAmount.setColumns(12);
			transactionDescription.setColumns(12);
			this.setTitle(" Subtract Charge For: " + currentCardName);
			JButton subtractChargeOKButton = new JButton("OK");
			adjustChargeBottomPanel.add(subtractChargeOKButton, BorderLayout.SOUTH);

			class SubtractChargeOKButtonListener implements ActionListener {
				private JFrame adjustChargeJFrame;

				public SubtractChargeOKButtonListener(JFrame adjustChargeJFrame) {
					this.adjustChargeJFrame = adjustChargeJFrame;
				}

				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String transactionDescriptionString = transactionDescription.getText();
					String chargeAmountString = chargeAmount.getText();
					int chargeAmountInteger = Integer.parseInt(chargeAmountString);
					cardMap.get(currentCardName).subtractBalance(chargeAmountInteger);
					TransactionLog newLog = new TransactionLog((new Date()).toString(), transactionDescriptionString,
							-1 * chargeAmountInteger, cardMap.get(currentCardName).gethcbalance());
					cardMap.get(currentCardName).getTransactions().add(newLog);
					this.adjustChargeJFrame.setVisible(false);
					this.adjustChargeJFrame.dispose();
					homepage.displayAllCards();

				}
			}

			subtractChargeOKButton.addActionListener(new SubtractChargeOKButtonListener(this));
			adjustChargeBottomPanel.add(subtractChargeOKButton, BorderLayout.SOUTH);
			this.add(adjustChargeTopPanel);
			this.add(adjustChargeMiddlePanel);
			this.add(adjustChargeBottomPanel);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.pack();
			this.setVisible(true);
		}

	}
}
