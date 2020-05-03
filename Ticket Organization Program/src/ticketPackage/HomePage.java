package ticketPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class HomePage {
	private HashMap<String, Integer> cardMap;
	private JFrame homePage;

	public HomePage() {

		cardMap = new HashMap<String, Integer>();
		homePage = new JFrame();
		AddCardJFrame AddCardJFrameClass = new AddCardJFrame(cardMap, this);
		JButton addCardButton = new JButton("Add Card Icon");
		JPanel addCardPanel = new JPanel();
		addCardPanel.add(addCardButton);
		homePage.add(addCardPanel);
		homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePage.setVisible(true);
		homePage.pack();

	}

	class AddCardListener implements ActionListener {
		private HashMap cardMap;
		private HomePage homePage;
		public void actionPerformed(ActionEvent e) {
			//AddCardJFrame AddCardJFrameClass = new AddCardJFrame(cardMap, this.homePage);
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
		for (String key : cardMap.keySet()) {
			System.out.println(key);
			System.out.println(cardMap.get(key));
			JButton tileCardButton = new JButton("<html>" + key + "<br/>" + "¥" + cardMap.get(key) + "</html>");
			JPanel newPanel = new JPanel();
			homePage.add(newPanel, BorderLayout.SOUTH);
			newPanel.add(tileCardButton, BorderLayout.CENTER);

			// System.out.println(cardMap.);
		}
		homePage.setVisible(true);
		homePage.pack();
	}

}
