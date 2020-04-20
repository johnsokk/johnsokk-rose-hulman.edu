package ticketPackage;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCardJFrame {
	
		public AddCardJFrame() {
		
		// Creating a JFrame, JPanel and JLabel. This is for adding the card 
			
		JFrame addCardFrame = new JFrame();
		JPanel addCardPanel = new JPanel();
		JLabel addCardLabel = new JLabel();
		
		// Setting title of the JFrame to "Add Card" 
		
		JTextField cardName = new JTextField("");
		JTextField cardBalance = new JTextField("");
		JTextField cardExpiration = new JTextField("");
		
		JLabel nameLabel = new JLabel("Please name your IC card");
		JLabel balanceLabel = new JLabel("What is your IC card balance?");
		JLabel expirationLabel = new JLabel("When does your IC card expire?");
		
		JPanel topPanel = new JPanel();
		
		addCardPanel.add(topPanel, BorderLayout.NORTH);
		
		cardName.setBounds(0, 1000, 1200, 1130);
		cardBalance.setBounds(0, 1000, 1200, 1130);
		cardExpiration.setBounds(0, 1000, 1200, 1130);
		
		topPanel.add(cardName, BorderLayout.NORTH);
		topPanel.add(cardBalance, BorderLayout.EAST);
		topPanel.add(cardExpiration, BorderLayout.SOUTH);
		
		topPanel.add(nameLabel, BorderLayout.NORTH);
		topPanel.add(balanceLabel, BorderLayout.EAST);
		topPanel.add(expirationLabel, BorderLayout.WEST);
		
		addCardFrame.setTitle("Add Card");
		addCardFrame.add(addCardLabel, BorderLayout.CENTER);
		addCardFrame.add(addCardPanel, BorderLayout.SOUTH); 
		
		JButton addCardButton = new JButton("Add Card");
		
		addCardPanel.add(addCardButton);
		
		String cardName1 = JOptionPane.showInputDialog(addCardFrame, "Enter a name for the card");
		
		addCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		addCardFrame.pack();
		addCardFrame.setVisible(true);
		
		
		
	}
	

	
}
