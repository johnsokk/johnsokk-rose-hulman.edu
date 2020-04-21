package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCardJFrame {
	
		public AddCardJFrame() {
		
		// Creating a JFrame, JPanel and JLabel. This is for adding the card 
			GridLayout myLayout = new GridLayout(4,1);  


		JFrame addCardFrame = new JFrame();
		JPanel addCardPanel = new JPanel();
		JLabel addCardLabel = new JLabel();
		addCardFrame.setLayout(myLayout);  

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
//		addCardFrame.add(addCardLabel);
//		addCardFrame.add(addCardPanel); 
		
		addCardFrame.add(topPanel);
		addCardFrame.add(middlePanel);
		addCardFrame.add(bottomPanel);
		
		
		JButton addCardButton = new JButton("Add Card");
		
		//addCardFrame.add(addCardButton);
		addCardPanel.add(addCardButton);
		addCardButtonPanel.add(addCardButton, BorderLayout.CENTER);
		addCardFrame.add(addCardButtonPanel);
	
		addCardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		addCardFrame.pack();
		addCardFrame.setVisible(true);
		
		
	}
	
}
