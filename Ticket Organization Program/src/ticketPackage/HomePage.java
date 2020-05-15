package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HomePage {
	private HashMap<String, Card> cardMap;
	private JFrame homePage;
	private JPanel cardPanel;
	private TransactionLinkedList searchLinkedList;

	public HomePage() {

		cardPanel = new JPanel();
		cardMap = new HashMap<String, Card>();
		homePage = new JFrame();
		// AddCardJFrame AddCardJFrameClass = new AddCardJFrame(cardMap, this);
		//GridLayout homePageLayout = new GridLayout(3, 1);
		//homePage.setLayout(homePageLayout);
		JButton addCardButton = new JButton("Add Card Icon");
		addCardButton.addActionListener(new AddCardListener(this.cardMap, this));
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("<html>" + "Welcome! Select the 'Add Card Icon' button" + "<br/>"
				+ "below to add a card to your card library." + "</html>");
		welcomeLabel.setBorder(new EmptyBorder(0, 20, 0, 20));
		homePage.add(welcomeLabel, BorderLayout.NORTH);


		JPanel addCardPanel = new JPanel();
		addCardPanel.add(addCardButton);
		homePage.add(addCardPanel, BorderLayout.SOUTH);
		//homePage.add(cardPanel);
		homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePage.setVisible(true);
		homePage.pack();

	}

	class AddCardListener implements ActionListener {
		private HashMap<String, Card> cardMap;
		private HomePage homePage;

		public AddCardListener(HashMap<String, Card> cardMap, HomePage homePage) {
			this.homePage = homePage;
			this.cardMap = cardMap;
		}

		public void actionPerformed(ActionEvent e) {
			AddCardJFrame AddCardJFrameClass = new AddCardJFrame(this.cardMap, this.homePage, searchLinkedList);

			// System.out.println("Check check");
		}
	}
	// private void AddCardJFrame() {
	// TODO Auto-generated method stub
	// }

	public void displayAllCards() {
		cardPanel.removeAll();
		GridLayout cardLayout = new GridLayout(cardMap.size() + 1, 1);
		cardPanel.setLayout(cardLayout);
		JLabel confirmationText = new JLabel("<html>" + "     " +"<br/>" + "Please click on the cards below" + 
				"<br/>" + 								"to display card options." + "</html>");
		cardPanel.setBorder(new EmptyBorder(20, 20, 0, 20));
		cardPanel.add(confirmationText);
		for (String key : cardMap.keySet()) {

			// System.out.println(key);
			// System.out.println(cardMap.get(key));

			// System.out.println(cardMap.);

			JButton tileCardButton = new JButton("<html>" + key + "<br/>" + "¥" + cardMap.get(key).gethcbalance() + "</html>");
			tileCardButton.addActionListener(new CardButtonListener(cardMap, key, this));
			cardPanel.add(tileCardButton);

			// newPanel.add(tileCardButton);
			// homePage.add(newPanel);
			// System.out.println(cardMap.);

		}
		homePage.add(cardPanel, BorderLayout.SOUTH);
		homePage.pack();
		homePage.setVisible(true);

	}

}
