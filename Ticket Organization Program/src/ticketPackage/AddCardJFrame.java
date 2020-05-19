package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCardJFrame extends JFrame {

	private HashMap<String, Card> cardMap;
	private JTextField cardName;
	private JTextField cardBalance;
	private JTextField cardExpiration;
	private HomePage homepage;
	private String expDate;
	private String str;
	private Integer hcbalance;

	public AddCardJFrame(HashMap<String, Card> cardMap, HomePage homepage, TransactionLinkedList searchLinkedList) {
		this.homepage = homepage;
		this.cardMap = cardMap;

		// Creating a grid. We need a grid because if we only use a JPanel, it only
		// allows for three sections,
		// as we learned while we were coding.
		GridLayout myLayout = new GridLayout(4, 1);

		// Creating a JPanel and JLabel. This is for adding the card
		JPanel addCardPanel = new JPanel();

		// Allows for our window to open
		this.setLayout(myLayout);

		// Creating labels for each question we want to ask the user
		JLabel nameLabel = new JLabel("Please name your IC card.            ");

		JLabel balanceLabel = new JLabel("What is your IC card balance?   ¥");

		JLabel expirationLabel = new JLabel("When does your IC card expire? ");

		// Creating four different panels for each of the JLabels to go on, as well as
		// the "Add Card" button.
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel addCardButtonPanel = new JPanel();

		// Creating three JTextfields for the users to enter information
		cardName = new JTextField("");
		cardBalance = new JTextField("");
		cardExpiration = new JTextField("YYYY/MM/DD");

		// Adds the JLabels to the window
		topPanel.add(nameLabel, BorderLayout.NORTH);
		middlePanel.add(balanceLabel, BorderLayout.NORTH);
		bottomPanel.add(expirationLabel, BorderLayout.NORTH);

		// Adds the the JTextfields to the window
		topPanel.add(cardName, BorderLayout.NORTH);
		middlePanel.add(cardBalance, BorderLayout.NORTH);
		bottomPanel.add(cardExpiration, BorderLayout.NORTH);

		// This makes the three text boxes for each of the JTextFields
		cardName.setColumns(12);
		cardBalance.setColumns(12);
		cardExpiration.setColumns(12);

		// Creating the title for this window
		this.setTitle("Add Card");

		// Adds the three panels onto the window
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);

		JButton addCardButton = new JButton("Add Card");
		addCardButton.addActionListener(new AddCardButtonListener(this));
		addCardPanel.add(addCardButton);
		addCardButtonPanel.add(addCardButton, BorderLayout.CENTER);
		this.add(addCardButtonPanel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

	public void addCardToHome() { // add to hash map etc
		String str = cardName.getText();
		String homecardbalance = cardBalance.getText();
		int hcbalance = Integer.parseInt(homecardbalance);
		String expDate = cardExpiration.getText();
		System.out.println(expDate);
		JButton addCardButton = new JButton(str);
		Card newCard = new Card(str, hcbalance, expDate);
		cardMap.put(str, newCard);
		addCardButton.addActionListener(new CardButtonListener(cardMap, str, homepage));
		homepage.displayAllCards();
	}

	public void addTransaction() {
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
}
