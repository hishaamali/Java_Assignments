import javax.swing.JOptionPane;

//Hishaam Ali CSCI212 Lab Section 11D

public class Project0 {

	public static void main (String[] args) {
		while (true) { // We want the program to loop forever. 
			String inputSentence = JOptionPane.showInputDialog(null, "Type a sentence. Enter the word stop to exit.");
			int lowCount = 0;
			int upperCount = 0; 
			if (inputSentence.equalsIgnoreCase("STOP")) { // To exit and break the loop, the user must enter the word stop (doesn't matter if it is lowercase or capital). 
				JOptionPane.showMessageDialog(null, "Finished");
				System.exit(0); 
				}
			for (int i = 0; i < inputSentence.length(); i++) { // Loop scans each character of the sentence, until the sentence is done.
				if (inputSentence.charAt(i) == 'e') { // Every time there is a lower case e in the position, we want to add 1 to the count. 
				lowCount++;
				}
				else if (inputSentence.charAt(i) == 'E') { // Every time there is a uppercase E, we want to add 1 to the count. 
					upperCount++;
				}
			}
			JOptionPane.showMessageDialog(null, "Number of lowercase e's: " + lowCount + "\n Number of uppercase E's: " + upperCount);	    
		}
	}
}
