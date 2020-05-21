package ticketPackage;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
// Author Killian

public class TransactionLogWriter extends JFrame {
	public void writetransactions(TransactionLinkedList transactions) {
		// Creates a new file
		File chosenfile = this.getfiletowrite();
		// If the user selects a file that doesn't exist, this prevents the code from
		// breaking
		if (chosenfile == null) {
			return;
		}
		// This adds the transaction data to the file that the user selected above
		writedatatofile(transactions, chosenfile);
	}

	public void writedatatofile(TransactionLinkedList transactions, File currentFile) {
		try {
			// This creates a 2D array of transactions to be written to the file
			Object[][] log = transactions.transactionLogToTableData();
			// Enables the ability to write to the selected file
			FileWriter newFile = new FileWriter(currentFile);
			// Loops through the 2D array created above, and prints the contents to the file
			for (int i = 0; i < log.length; i++) {
				newFile.write((String) log[i][0] + " ");
				newFile.write((String) log[i][1] + " ");
				newFile.write((String.valueOf(log[i][2])) + " ");
				newFile.write((String.valueOf(log[i][3])) + " " + String.format("%n"));
			}
			// Closes the file that the user selected
			newFile.close();
			// Prints error if file type is incorrect
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File getfiletowrite() {
		// Opens a new window to allow the user to select a file
		JFileChooser fileChooser = new JFileChooser("d:");
		// Gets the file type
		int returnVal = fileChooser.showOpenDialog(this);
		// Checks the file type
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			// Prints out encouraging dialogue if the file type is correct
			System.out.println("You chose to open this file: " + fileChooser.getSelectedFile().getName());
			// Checks if file type is right (again)
			if (!fileChooser.getSelectedFile().getName().endsWith(".txt")) {
				// Prints error message to file to let the user know they done screwed up
				System.out.println("Please select a txt file.");
				return null;
			}
			// Assigns file to the chosen file
			File currentFile = fileChooser.getSelectedFile();
			// Spits assigned file back out
			return currentFile;
		}
		return null;
	}
}