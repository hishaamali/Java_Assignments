import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.Container;
import java.awt.TextArea;


public class BoxGUI extends JFrame {
	Container myContentPane = getContentPane();
	TextArea unsorted = new TextArea();
	TextArea sorted = new TextArea();
	Box[] unsortedBox;
	Box[] sortedBox;

	public BoxGUI(Box[] myBoxes) {
		setSize(400,200); 
		setLocation(100,100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Project 1");
		setLayout(new GridLayout(1,2));
		myContentPane.add(unsorted); //adds the textarea of the unsorted box to the GUI
		myContentPane.add(sorted);		// adds the textarea of the sorted box to the GUI
		unsortedBox = myBoxes;			//sets unsortedBox to the Box array that was created from the text file.
		for (int i = 0 ; i < unsortedBox.length; i++) {	// goes through the unsorted box, and prints it using toString. 
			unsorted.append(unsortedBox[i].toString() + "\n");
		}
		SelectionSort(myBoxes);
		sortedBox = myBoxes;
		for (int i = 0; i < sortedBox.length; i++) {	// goes through the sorted box , and prints it using toString. 
			sorted.append(sortedBox[i].toString() + "\n");
		}
		setVisible(true);
		
		
	}

	
	public static void SelectionSort(Box[] boxes) {	// Sorts the Box using Selection Sort by Box Volume.
		for (int i = 0; i < boxes.length; i++) {
			int low = i;
			for (int j = 0; j < boxes.length; j++) {
				if (boxes[j].Volume() > boxes[low].Volume()) {	
					low = j;
				}
			Box temp = boxes[i];
			boxes[i] = boxes[low];	// creates a temporary box to proceed with the swapping
			boxes[low] = temp;
			}
		}
	}


}




	

		
		


