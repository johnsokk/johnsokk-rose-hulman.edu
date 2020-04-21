package ticketPackage;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	
	public static void main(String[] args) {
		
		JFrame homePage = new JFrame();
		AddCardJFrame AddCardJFrameClass = new AddCardJFrame();
		JButton addCardButton = new JButton("Add Card Icon");
		JPanel addCardPanel = new JPanel();
		addCardPanel.add(addCardButton);
		homePage.add(addCardPanel);
		homePage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		homePage.pack();
		homePage.setVisible(true);
	}
	
//	public class MainListener implements ActionListener{ 
//		public void actionPerformed(ActionEvent e) {
//			
//			String ticketName = JOptionPane.showInputDialog("Enter a name for the ticket/card");
//			String ticketCost = JOptionPane.showInputDialog("What is the current balance on the ticket/card?");
//			int nTickets = Integer.parseInt(ticketCost);
//			
//			JFrame  myFrame = new JFrame();
//			JPanel mypanel = new JPanel();
//			myFrame.setTitle("Add Ticket Information");
//			myFrame.add(mypanel, BorderLayout.CENTER);
//			
//			myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			myFrame.pack();
//			myFrame.setVisible(true);
//
//			
//		}

	private void AddCardJFrame() {
		// TODO Auto-generated method stub
		
	}
	 
	
}



