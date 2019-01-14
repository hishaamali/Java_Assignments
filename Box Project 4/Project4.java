import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;
//Hishaam Ali Lab Section 11D
public class Project4 {
	  public static void main(String[] args) {
	     int[][] BoxInfo = fillArray("boxes.txt");
	     HashMap<Box,Integer> ubl = new HashMap<Box,Integer>();		//creates HashMap
	     TreeMap<Box,Integer> sbl = new TreeMap<Box,Integer>();		// creates a TreeMap
	     for (int i = 0; i < BoxInfo.length; i++) {	//goes through BoxInfo
	    	 try {
	    		 int l = BoxInfo[i][0];		
	    		 int w = BoxInfo[i][1];		// sets the length, width and height from the array 
	    		 int h = BoxInfo[i][2];
	    		 Box box = new Box(l,w,h);	//creates the Box
	    		 ubl.put(box, box.Volume()); // adds the content of the Box from UnsortedBoxList
	    		 sbl.put(box, box.Volume());	// adds the content of the Box from SortedBoxlist
	    		 }
	    										
	    	catch(IllegalBoxException e) {		// of 
	    		System.err.println("Box is not valid");
	    	}
	 }
	     BoxGUI b = new BoxGUI(ubl, sbl);
	  }
	   public static int[][] fillArray(String myFile) {
	        TextFileInput input = new TextFileInput(myFile);
	        
	        // reads the first line of the input file, 
	        String line = input.readLine();
	        // tokenizes it to get the number of rows and columns,
	        StringTokenizer myTokens = new StringTokenizer(line,",");    
	        int row =  Integer.parseInt(myTokens.nextToken());
	        int col =  Integer.parseInt(myTokens.nextToken());
	       
	        System.out.println("The dimension of the array is: " + row + ' ' + col);
	        // creates a two-dimension array of integers of the proper dimensions
	        int[][] integers = new int[row][col];
	        // reads the rest of the file, 
	        // tokenizing each line and storing the number in the array
	        for (int i = 0; i < row; i++) {
	           StringTokenizer rowToken = new StringTokenizer(input.readLine(),",");
	           int j = 0;
	           while (rowToken.hasMoreTokens()) {
	              integers[i][j]= Integer.parseInt(rowToken.nextToken());
	              j++;
	           }

	       }
	       return integers;   
	     }

}