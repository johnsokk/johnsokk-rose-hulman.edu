package ticketPackage;

import java.io.FileFilter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TransactionLogWriter extends JFrame {

	public TransactionLogWriter() {
		JFileChooser fileChooser = new JFileChooser("d:");		
	    //FileNameExtensionFilter filter = new FileNameExtensionFilter(
	    //   "txt");
	    //fileChooser.setFileFilter(filter);
	    int returnVal = fileChooser.showOpenDialog(this);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	       System.out.println("You chose to open this file: " +
	            fileChooser.getSelectedFile().getName());
	       
	    }
	    //FileFilter filter1 = new ExtensionFileFilter("Text File", new String[] { "TXT"});
	    //fileChooser.setFileFilter(filter1);
	}
}