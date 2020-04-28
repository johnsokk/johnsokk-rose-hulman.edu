package ticketPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddCardJFrame extends JFrame {
	
		public AddCardJFrame() {
		//	this.homePageJFrame = homePageJFrame;
		// Creating a grid 
		GridLayout myLayout = new GridLayout(4,1);  

		// Creating a JPanel and JLabel. This is for adding the card 
		JPanel addCardPanel = new JPanel();
		//JLabel addCardLabel = new JLabel();
		
		this.setLayout(myLayout);  

		// Creating labels for each question we want to ask the user
		JLabel nameLabel = new JLabel("Please name your IC card.            ");
		JLabel balanceLabel = new JLabel("What is your IC card balance?     ");
		JLabel expirationLabel = new JLabel("When does your IC card expire? ");
		
		// Creating four different panels t
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
		
		this.setTitle("Add Card");
		
		this.add(topPanel);
		this.add(middlePanel);
		this.add(bottomPanel);
		
		JButton addCardButton = new JButton("Add Card");
		addCardButton.addActionListener(new AddCardButtonListener(this)); 
		addCardPanel.add(addCardButton);
		addCardButtonPanel.add(addCardButton, BorderLayout.CENTER);
		this.add(addCardButtonPanel);
		
		System.out.print(cardName);
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		this.pack();
		this.setVisible(true);
		
	}
		}
