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
// Killian, Kaia, Braden

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
		// Creates a column layout to be added to the JFrame later
		GridLayout myLayout = new GridLayout(3, 1);
		// Creates three new panels to add buttons to later
		JPanel adjustChargeTopPanel = new JPanel();
		JPanel adjustChargeMiddlePanel = new JPanel();
		JPanel adjustChargeBottomPanel = new JPanel();
		// Sets the layout to the frame
		this.setLayout(myLayout);
		// If the boolean that gets passed in is positive, it opens an add charge JFrame
		// If the boolean that gets passed in is positive, it opens a subtract charge
		// JFrame
		if (this.isPositive == true) {
			// This sets the text to prompt the user to enter an integer
			String howMuchCharge = JOptionPane.showInputDialog("How much charge did you add?");
			// This allows for the try catch error variable to be initialized.
			int addedCharge = -1;
			try {
				// Parse the integer to see if user put in a valid integer
				addedCharge = Integer.parseInt(howMuchCharge);
			} catch (NumberFormatException exception) {
				// If the user inputs any character that is not an integer, it will throw this message.
				JOptionPane.showMessageDialog(null,
						"Please input a number without decimals or commas that is less than ten digits.");
				return;
			}
			// This updates the charge in the Card class
			cardMap.get(currentCardName).addBalance(addedCharge);
			// This adds the appropriate information to track the transaction
			TransactionLog newLog = new TransactionLog((new Date()).toString(), "Deposit", addedCharge,
					cardMap.get(currentCardName).gethcbalance());
			cardMap.get(currentCardName).getTransactions().add(newLog);
			// This calls the homePage to update all the cards and their balances
			homepage.displayAllCards();

		} else {
			// This is the alternative boi when the boolean is false and the user wants to
			// subtract charge
			// from the card balance
			// These next lines prompt the user to input the correct information for the
			// transaction
			JLabel chargeLabel = new JLabel("How much charge did you spend?          ¥");
			JLabel itemLabel = new JLabel("How did you spend your charge?               ");
			chargeAmount = new JTextField("");
			transactionDescription = new JTextField("  ");
			// This adds the correct buttons to panels and panels to frames
			adjustChargeTopPanel.add(chargeLabel, BorderLayout.NORTH);
			adjustChargeMiddlePanel.add(itemLabel, BorderLayout.NORTH);
			adjustChargeTopPanel.add(chargeAmount, BorderLayout.CENTER);
			adjustChargeMiddlePanel.add(transactionDescription, BorderLayout.CENTER);
			// This line determines the maximum number of digits that can be input for the
			// amount
			chargeAmount.setColumns(12);
			transactionDescription.setColumns(12);
			// This line reminds the user which card's balance is being updated
			this.setTitle(" Record Expense For: " + currentCardName);
			// This button signifies that the user is finished inputing information
			JButton subtractChargeOKButton = new JButton("OK");
			// This adds the button to the panel
			adjustChargeBottomPanel.add(subtractChargeOKButton, BorderLayout.SOUTH);
			// This adds a listener to the button
			class SubtractChargeOKButtonListener implements ActionListener {
				private JFrame adjustChargeJFrame;

				public SubtractChargeOKButtonListener(JFrame adjustChargeJFrame) {
					this.adjustChargeJFrame = adjustChargeJFrame;
				}

				public void actionPerformed(ActionEvent e) {
					// These next lines get the text from the text boxes and puts them in a usable
					// form
					String transactionDescriptionString = transactionDescription.getText();
					String chargeAmountString = chargeAmount.getText();
					// This allows for the try catch error variable to be initialized.
					int chargeAmountInteger = -1;
					try {
						// Parse the integer to see if user put in a valid integer
						chargeAmountInteger = Integer.parseInt(chargeAmountString);
					} catch (NumberFormatException exception) {
						// If the user inputs any character that is not an integer, it will throw this message.
						JOptionPane.showMessageDialog(null,
								"Please input a number without decimals or commas that is less than ten digits.");
						return;
					}

					// Gets the current balance for the card
					cardMap.get(currentCardName).subtractBalance(chargeAmountInteger);
					// Adds transaction to the log
					TransactionLog newLog = new TransactionLog((new Date()).toString(), transactionDescriptionString,
							-1 * chargeAmountInteger, cardMap.get(currentCardName).gethcbalance());
					cardMap.get(currentCardName).getTransactions().add(newLog);
					// Closes previous window to declutter
					this.adjustChargeJFrame.setVisible(false);
					this.adjustChargeJFrame.dispose();
					// This calls the homePage to update all the cards and their balances
					homepage.displayAllCards();

				}
			}
			// Adds a listener to the OK button
			subtractChargeOKButton.addActionListener(new SubtractChargeOKButtonListener(this));
			// Adds the correct stuff to the panel and the correct panels to the frame
			adjustChargeBottomPanel.add(subtractChargeOKButton, BorderLayout.SOUTH);
			this.add(adjustChargeTopPanel);
			this.add(adjustChargeMiddlePanel);
			this.add(adjustChargeBottomPanel);
			// Correct stuff to make the window to display right
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.pack();
			this.setVisible(true);
		}

	}
}
