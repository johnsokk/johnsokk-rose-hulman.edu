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
// Author Braden

public class DeleteCardConfirmationJFrame extends JFrame {
	private HashMap<String, Card> cardMap;
	private HomePage homePage;
	private String currentCardName;

	public DeleteCardConfirmationJFrame(HashMap<String, Card> cardMap, HomePage homePage, String currentCardName) {
		this.cardMap = cardMap;
		this.homePage = homePage;
		this.currentCardName = currentCardName;
		// Sets the title to remind the user which card they are deleting
		this.setTitle("Delete " + currentCardName + "?");
		// Sets the text of the window to confirm desire to delete
		JLabel confirmationText = new JLabel("<html>" + "Are you sure you would like to permanently" + "<br/>"
				+ "remove this card from your homepage?" + "<br/>" + "Deleting this card will also delete its data."
				+ "</html>");
		// Creates new panels and buttons
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
				// Deletes the card fromt the map
				this.cardMap.remove(this.currentCardName);
				// Calls homePage to refresh the list of cards on homePage
				this.homePage.displayAllCards();
				// Closes the current window to declutter
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
				// Closes the current window to declutter and return to homePage
				this.deleteCardConfirmationJFrame.setVisible(false);
				this.deleteCardConfirmationJFrame.dispose();
			}
		}
		// Adds a listener to the no button
		noButton.addActionListener(new noButtonListener(this));
		// Adds the buttons to the panel
		yesnoButtonPanel.add(yesButton);
		yesnoButtonPanel.add(noButton);
		// Layout stuff for the window
		this.add(textPanel, BorderLayout.NORTH);
		this.add(yesnoButtonPanel, BorderLayout.SOUTH);
		// Does necessary stuff to get the JFrame to show up right
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}