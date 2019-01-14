import javax.swing.*;
import java.util.StringTokenizer;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ToolsMenuHandler implements ActionListener {
   JFrame jframe;
   
   public ToolsMenuHandler (JFrame jf) {
      jframe = jf;
   }
   
   public void actionPerformed(ActionEvent event) {
	  String input;
	  input = JOptionPane.showInputDialog(null,"Enter dimensions of box as follows: length,width,height");
	  StringTokenizer tokens = new StringTokenizer(input, ",");
      String menuName = event.getActionCommand();
      if (tokens.countTokens() != 3) 
    	  JOptionPane.showMessageDialog(null, "Please enter 3 dimensions");
      
      int length, width, height;
		try {
			//change the numbers in the string into integers to be used.
			length = Integer.parseInt(tokens.nextToken());
			width = Integer.parseInt(tokens.nextToken());
			height = Integer.parseInt(tokens.nextToken());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter 3 valid dimensions of the box.");
			return;
		}
		
		if (length < 1 || width < 1 || height < 1) {
			JOptionPane.showMessageDialog(null, "The dimensions of the box cannot be less than 1.");
			return;
		}
		
		//Find the volume of the searched box
		int volume = length * width * height;
		//Create a new JFrame in order to display the result.
		JFrame result = new JFrame();
		result.setTitle("Boxes that are able to fit with the common volume of: " + volume);
		result.setSize(400, 400);
		result.setLocation(800, 200);
		TextArea resultArea = new TextArea();
		result.getContentPane().add(resultArea);
		
	    int[][] BoxInfo = Project3.fillArray("boxes.txt");
	    SortedBoxList sbl = new SortedBoxList();
	    for (int i = 0; i < BoxInfo.length; i++) {//goes through BoxInfo
	    	try {
	    		 int l = BoxInfo[i][0];		
	    		 int w = BoxInfo[i][1];		// sets the length, width and height from the array 
	    		 int h = BoxInfo[i][2];
	    		 Box box = new Box(l,w,h);	//creates the Box
	    		 sbl.add(box);	// adds the content of the Box from SortedBoxlist
	    	 }
	    	catch(IllegalBoxException e) {
	    		System.err.println("Box is not valid");
	    	}
	 }
		//Show to results found that are greater than the box searched.
		BoxNode rNode = sbl.first.next;
		while (rNode != null) {
			if (rNode.data.Volume() >= volume) {
				resultArea.append(rNode.data.toString() + "\n");
			}
			rNode = rNode.next;
		}
		result.setVisible(true);
   		}
}
   