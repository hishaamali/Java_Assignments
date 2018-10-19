import java.util.StringTokenizer;

public class Project1 {
	public static void main(String[] args)  {
		int [][] boxInfo = fillArray("box");
		Box [] myBoxes = putBox(boxInfo); 
		BoxGUI Box = new BoxGUI(myBoxes);
	}

	public static int [][] fillArray(String myFile) { // Fills in a 2D array by using the TextFile
		TextFileInput input = new TextFileInput(myFile);
		String line = input.readLine(); //reads first line of input file.
		StringTokenizer myTokens = new StringTokenizer(line,","); //tokenizes it to get the number of rows and columns. 
		int row = Integer.parseInt(myTokens.nextToken());
		int col = Integer.parseInt(myTokens.nextToken());
		int[][] boxArray = new int [row][col]; //creates 2D array of integers. 
		for (int i = 0; i < row; i++) { //reads the file, tokenizes each line and stores the number in the array. 
	          StringTokenizer rowToken = new StringTokenizer(input.readLine(),",");
	          int j = 0;
	          while (rowToken.hasMoreTokens()) {
	             boxArray[i][j]= Integer.parseInt(rowToken.nextToken());
	             j++;
	          }
	      }
		return boxArray;
		
	}
	
	public static Box [] putBox(int[][] boxInfo) {	// Puts the 2D array created into a 1D array
		Box [] boxes = new Box[boxInfo.length];
		for (int i = 0; i < boxInfo.length; i++) {
			int length = boxInfo[i][0];
			int width = boxInfo [i][1];
			int height = boxInfo [i][2];
			boxes[i] = new Box(length,width,height);
		}
		return boxes;
	}
}
