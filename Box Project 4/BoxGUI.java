import java.awt.*;
import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.*;

public class BoxGUI extends JFrame{
	/**
	 * 
	 */
	Container container;
	TextArea unsorted;
	TextArea sorted;
	JMenuBar menuBar = new JMenuBar();
	protected static TreeMap<Box,Integer> sbl;
   public BoxGUI(HashMap b1, TreeMap b2) {
	      // set the title of the JFrame
	      setTitle("Project 4");
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
	      createToolsMenu();
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
    }
  
   private void createToolsMenu( ) {
	      JMenuItem   item;
	      JMenu       fileMenu = new JMenu("Tools");
	      ToolsMenuHandler fmh  = new ToolsMenuHandler(this);

	      item = new JMenuItem("Search");    //Search
	      item.addActionListener( fmh );
	      fileMenu.add(item);        
	      setJMenuBar(menuBar);
	      menuBar.add(fileMenu);
	      
	    
	   } //createMenu

}