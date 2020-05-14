
package ticketPackage;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteCardConfirmationJFrame extends JFrame {
	private HashMap<String, Card> cardMap;
	private HomePage homePage;
	private String currentCardName;

	public DeleteCardConfirmationJFrame(HashMap<String, Card> cardMap, HomePage homePage, String currentCardName) {
		this.cardMap = cardMap;
		this.homePage = homePage;
		this.currentCardName = currentCardName;
		this.setTitle("Delete " + currentCardName + "?");
		JLabel confirmationText = new JLabel("<html>" + "Are you sure you would like to permanently" + 
										"<br/>" + 		"remove this card from your homepage?" +
										"<br/>" +		"Deleting this card will also delete its data." + "</html>");
		JPanel yesnoButtonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		textPanel.add(confirmationText);
		JButton yesButton = new JButton("Yes");

		class yesButtonListener implements ActionListener {
			private HashMap<String, Card> cardMap;
			private HomePage homePage;
			private String currentCardName;
			private JFrame deleteCardConfirmationJFrame;

			public yesButtonListener(HomePage homePage, HashMap<String, Card> cardMap, String currentCardName,
					JFrame deleteCardConfirmationJFrame) {
				this.cardMap = cardMap;
				this.homePage = homePage;
				this.currentCardName = currentCardName;
				this.deleteCardConfirmationJFrame = deleteCardConfirmationJFrame;
			}

			public void actionPerformed(ActionEvent e) {
				this.cardMap.remove(this.currentCardName);
				this.homePage.displayAllCards();
				this.deleteCardConfirmationJFrame.setVisible(false);
				this.deleteCardConfirmationJFrame.dispose();

			}
		}

		yesButton.addActionListener(new yesButtonListener(homePage, cardMap, currentCardName, this));
		JButton noButton = new JButton("No");

		class noButtonListener implements ActionListener {
			private JFrame deleteCardConfirmationJFrame;

			public noButtonListener(JFrame deleteCardConfirmationJFrame) {
				this.deleteCardConfirmationJFrame = deleteCardConfirmationJFrame;
			}

			public void actionPerformed(ActionEvent e) {
				this.deleteCardConfirmationJFrame.setVisible(false);
				this.deleteCardConfirmationJFrame.dispose();
			}
		}
		noButton.addActionListener(new noButtonListener(this));
		yesnoButtonPanel.add(yesButton);
		yesnoButtonPanel.add(noButton);
		this.add(textPanel, BorderLayout.NORTH);
		this.add(yesnoButtonPanel, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}