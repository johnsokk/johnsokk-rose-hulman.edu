package ticketPackage;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

// Author Braden
public class HomePage {
	private HashMap<String, Card> cardMap;
	private JFrame homePage;
	private JPanel cardPanel;
	private TransactionLinkedList searchLinkedList;

	public HomePage() {
		// Creates elements to add to the homePage frame
		cardPanel = new JPanel();
		// Stores card data with the card name as the key and Card class with the data
		cardMap = new HashMap<String, Card>();
		homePage = new JFrame();
		// Saves imported image as an icon to place into the button
		ImageIcon icon = new ImageIcon("icon.jpg");
		JButton addCardButton = new JButton("Add Card", icon);
		// Gets the icon to appear in the center of the button
		addCardButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		addCardButton.setHorizontalTextPosition(SwingConstants.CENTER);
		addCardButton.addActionListener(new AddCardListener(this.cardMap, this));
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("<html>" + "Welcome! Select the 'Add Card Icon' button" + "<br/>"
				+ "below to add a card to your card library." + "</html>");
		welcomeLabel.setBorder(new EmptyBorder(0, 20, 0, 20));
		// Adds label to the homePage
		homePage.add(welcomeLabel, BorderLayout.NORTH);
		JPanel addCardPanel = new JPanel();
		addCardPanel.add(addCardButton);
		// Adds panel to the homePage
		homePage.add(addCardPanel);
		// Gets homePage to display properly
		homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePage.setVisible(true);
		homePage.pack();
	}
	// In-line listener class for Add Card button
	class AddCardListener implements ActionListener {
		private HashMap<String, Card> cardMap;
		private HomePage homePage;

		public AddCardListener(HashMap<String, Card> cardMap, HomePage homePage) {
			this.homePage = homePage;
			this.cardMap = cardMap;
		}

		public void actionPerformed(ActionEvent e) {
			// Calls to create a new JFrame class for the Add Card Menu
			AddCardJFrame AddCardJFrameClass = new AddCardJFrame(this.cardMap, this.homePage, searchLinkedList);
		}
	}


	public void displayAllCards() {
		// clears panel so that homePage is refreshed
		cardPanel.removeAll();
		// Gets cards to display in neat, orderly fashion
		GridLayout cardLayout = new GridLayout(cardMap.size() + 1, 1);
		cardPanel.setLayout(cardLayout);
		// Provides instructions for the user to help guide once they add a card
		JLabel confirmationText = new JLabel("<html>" + "Please click on the cards below" + "<br/>"
				+ "to display card options." + "</html>");
		// Adds a small border to make it look pretty
		cardPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
		cardPanel.add(confirmationText);
		// Iterates through the hashMap of cards to create all of the new card buttons (with necessary information)
		for (String key : cardMap.keySet()) {
			// Card button factory
			JButton tileCardButton = new JButton("<html> <center>" + "Card Name: " + key + "       " + "<br/>"
					+ "Balance: ¥" + cardMap.get(key).gethcbalance() + "<br/>" + "Expiration Date: "
					+ cardMap.get(key).expDate() + "<center></html>");
			// Creates listeners for each card button
			tileCardButton.addActionListener(new CardButtonListener(cardMap, key, this));
			// Adds each card button to the homePage
			cardPanel.add(tileCardButton);
		}
		// Resizes homePage and gets it to appear nicely
		homePage.add(cardPanel, BorderLayout.SOUTH);
		homePage.pack();
		homePage.setVisible(true);

	}
}
