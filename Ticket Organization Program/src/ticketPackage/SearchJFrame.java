package ticketPackage;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchJFrame extends JFrame {
	
	private JTextField searchBox;
	private TransactionLinkedList searchLinkedList;
	
	public SearchJFrame(TransactionLinkedList searchLinkedList) {
		this.searchLinkedList = searchLinkedList;

		// Creating a JPanel and JLabel. This is for adding the card
		JPanel searchPanel = new JPanel();

		// Creating labels for each question we want to ask the user
		JLabel searchLabel = new JLabel("Please enter the item name you would like to search for.");
		
		// Creating three JTextfields for the users to enter information
		searchBox = new JTextField("");

		// Adds the JLabels to the window
		searchPanel.add(searchLabel, BorderLayout.NORTH);
		searchPanel.add(searchBox, BorderLayout.SOUTH);

		// This makes the text boxes for each of the JTextFields
		searchBox.setColumns(12);
		
		// Creating the title for this window
		this.setTitle("Search Box");


		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new SearchButtonListener(this.searchLinkedList, searchBox, this));
		searchPanel.add(searchButton, BorderLayout.CENTER);
		this.add(searchPanel);

		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);

	}

}
