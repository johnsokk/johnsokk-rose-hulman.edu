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
		
		// Creating labels for each question we want to ask the user
		JLabel nameLabel = new JLabel("Please name your IC card.            ");
		JLabel balanceLabel = new JLabel("What is your IC card balance?     ");
		JLabel expirationLabel = new JLabel("When does your IC card expire? ");
		
		// 
		JPanel topPanel = new JPanel();
		JPanel middlePanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		JPanel addCardButtonPanel = new JPanel();
		
		addCardPanel.add(topPanel, BorderLayout.CENTER);
		addCardPanel.add(middlePanel, BorderLayout.CENTER);
		addCardPanel.add(bottomPanel, BorderLayout.CENTER);
		
		JTextField cardName = new JTextField("");
		JTextField cardBalance = new JTextField("");
		JTextField cardExpiration = new JTextField("");
		
		topPanel.add(nameLabel, BorderLayout.NORTH);
		middlePanel.add(balanceLabel, BorderLayout.NORTH);
		bottomPanel.add(expirationLabel, BorderLayout.NORTH);
		
		topPanel.add(cardName, BorderLayout.NORTH);
		middlePanel.add(cardBalance, BorderLayout.NORTH);
		bottomPanel.add(cardExpiration, BorderLayout.NORTH);
		
		cardName.setColumns(12);
		cardBalance.setColumns(12);
		cardExpiration.setColumns(12);
		
		addCardFrame.setTitle("Add Card");
		addCardFrame.add(addCardLabel, BorderLayout.NORTH);
		addCardFrame.add(addCardPanel, BorderLayout.SOUTH); 
		
		addCardFrame.add(topPanel, BorderLayout.NORTH);
		addCardFrame.add(middlePanel, BorderLayout.CENTER);
		addCardFrame.add(bottomPanel, BorderLayout.SOUTH);
		
		JButton addCardButton = new JButton("Add Card");
		
		//addCardFrame.add(addCardButton);
		//addCardPanel.add(addCardButton);
//		addCardButtonPanel.add(addCardButton, BorderLayout.CENTER);
//		addCardFrame.add(addCardButtonPanel, BorderLayout.SOUTH);
	
		addCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		addCardFrame.pack();
		addCardFrame.setVisible(true);
		
		
	}
	
}
