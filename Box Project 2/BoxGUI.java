import java.awt.*;
import javax.swing.*;

public class BoxGUI extends JFrame{
	/**
	 * 
	 */
	Container container;
	TextArea unsorted;
	TextArea sorted;
   public BoxGUI(UnsortedBoxList b1, SortedBoxList b2) {
	      // set the title of the JFrame
	      setTitle("Project 1");
	      // set the location of the JFrame
	      setLocation(400, 200);
	      // set the size of the JFrame
	      setSize(500, 500);
	      // set the layout of the JFrame,   
	      setLayout(new GridLayout(1,2)); 
	      container = getContentPane();
	      unsorted = new TextArea();
	      sorted = new TextArea();
	      unsorted.setText("Unsorted:\n\n" + b1);
	      sorted.setText("Sorted:\n\n" + b2);
	      container.add(unsorted);
	      container.add(sorted);
	      
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
    }
  


}



	

		
		


