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

public class HomePage {
	private HashMap<String, Integer> cardMap;
	private JFrame homePage;
	private JPanel cardPanel;

	public HomePage() {
		
		cardPanel = new JPanel();
		cardMap = new HashMap<String, Integer>();
		homePage = new JFrame();
		//AddCardJFrame AddCardJFrameClass = new AddCardJFrame(cardMap, this);
		GridLayout homePageLayout = new GridLayout(4, 1);
		homePage.setLayout(homePageLayout);
		JButton addCardButton = new JButton("Add Card Icon");
		addCardButton.addActionListener(new AddCardListener(this.cardMap, this));
		JLabel welcomeLabel = new JLabel();
		welcomeLabel.setText("   Welcome! Select the 'Add Card Icon' button below to add a card to your card library.   ");
		homePage.add(welcomeLabel);
		
		JPanel addCardPanel = new JPanel();
		addCardPanel.add(addCardButton);
		homePage.add(addCardPanel);
		homePage.add(cardPanel);
		homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePage.setVisible(true);
		homePage.pack();
		
	}

	class AddCardListener implements ActionListener {
		private HashMap<String, Integer> cardMap;
		private HomePage homePage;

		public AddCardListener(HashMap cardMap, HomePage homePage) {
			this.homePage = homePage;
			this.cardMap = cardMap;
		}
		public void actionPerformed(ActionEvent e) {
			AddCardJFrame AddCardJFrameClass = new AddCardJFrame(this.cardMap, this.homePage);
			
			//System.out.println("Check check");
		}
	}
//public class MainListener implements ActionListener{ 
//	public void actionPerformed(ActionEvent e) {
//		
//		String ticketName = JOptionPane.showInputDialog("Enter a name for the ticket/card");
//		String ticketCost = JOptionPane.showInputDialog("What is the current balance on the ticket/card?");
//		int nTickets = Integer.parseInt(ticketCost);
//		
//		JFrame  myFrame = new JFrame();
//		JPanel mypanel = new JPanel();
//		myFrame.setTitle("Add Ticket Information");
//		myFrame.add(mypanel, BorderLayout.CENTER);
//		
//		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		myFrame.pack();
//		myFrame.setVisible(true);
//
//		
//	}

	// private void AddCardJFrame() {
	// TODO Auto-generated method stub
	// }

	public void displayCard() {
		cardPanel.removeAll();
		GridLayout cardLayout = new GridLayout(cardMap.size(), 1);
		cardPanel.setLayout(cardLayout);
		for (String key : cardMap.keySet()) {

			System.out.println(key);
			System.out.println(cardMap.get(key));
			
			//System.out.println(cardMap.);

			JButton tileCardButton = new JButton("<html>" + key + "<br/>" + "¥" + cardMap.get(key) + "</html>");
			
			cardPanel.add(tileCardButton);
			//newPanel.add(tileCardButton);
			//homePage.add(newPanel);
			// System.out.println(cardMap.);

		}
		homePage.setVisible(true);
		homePage.pack();
	}

}
