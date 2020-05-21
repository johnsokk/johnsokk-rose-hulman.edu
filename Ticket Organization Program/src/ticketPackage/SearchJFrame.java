package ticketPackage;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
// Author Kaia

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
		// Makes a new search button
		JButton searchButton = new JButton("Search");
		// Adds a listener to the search button
		searchButton.addActionListener(new SearchButtonListener(this.searchLinkedList, searchBox, this));
		// Adds the button to the panel
		searchPanel.add(searchButton, BorderLayout.CENTER);
		// Adds the panel to the Frame
		this.add(searchPanel);
		// Does necessary stuff to get the frame to behave properly
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
