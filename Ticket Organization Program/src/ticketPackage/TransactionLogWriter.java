package ticketPackage;

import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TransactionLogWriter extends JFrame {

	public void writetransactions(TransactionLinkedList transactions) {
		File chosenfile = this.getfiletowrite();
		if (chosenfile == null) {
			return;
		}
		writedatatofile(transactions, chosenfile);
	}
	public void writedatatofile(TransactionLinkedList transactions, File currentFile) {
		 try {
		    	Object[][] log = transactions.transactionLogToTableData();
				FileWriter newFile = new FileWriter(currentFile);
				for(int i=0; i< log.length; i++) {
					newFile.write((String) log[i][0] + " ");
					newFile.write((String) log[i][1]+ " ");
					newFile.write((String.valueOf(log[i][2]))+ " ");
					newFile.write((String.valueOf(log[i][3]))+ " "+ String.format("%n"));
					
				}
				newFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	public File getfiletowrite() {
		JFileChooser fileChooser = new JFileChooser("d:");		
	    int returnVal = fileChooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fileChooser.getSelectedFile().getName());
	    if (!fileChooser.getSelectedFile().getName().endsWith(".txt")){
	    	
	    	System.out.println("Please select a txt file.");
	    	return null;
	    }
	    File currentFile = fileChooser.getSelectedFile();
	    return currentFile;
		}
	    
	    return null;
	}
}
