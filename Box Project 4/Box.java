public class Box implements Comparable<Box> {
	private int length;
	private int width;
	private int height;
	
	public Box() {	//Constructor with no parameters 
		length = 1;
		width = 1;
		height = 1;
	}
	
	public Box(int l, int w, int h) {// Constructor with parameters
		if ((l<1) || (w<1) || (h<1)) throw new IllegalBoxException("Not a valid box");
		length = l;
		width = w;
		height = h;
	}
	
	public int Volume() {	// returns the Box Volume
		return length * width * height;
		
	}
	
	public int getLength() {	// Gets the length of Box
		return length;
	}
	
	public int getWidth() {	// Gets the width of Box
		return width;
	}
	
	public int getHeight() {	//Gets the height of Box
		return height;
	}
	
	public void setLength(int l) { // Sets length of Box, checks if it is valid. 
		if (l < 1) throw new IllegalBoxException("Size must be greater than 1");
		l = length;
	}
	
	public void setWidth(int w) {	//Sets width of Box, checks if it is valid. 
		if (w < 1) throw new IllegalBoxException("Size must be greater than 1");
		w = width;
	}
	
	public void setHeight(int h) { //Sets height of Box, checks if the size is valid.
		if (h < 1) throw new IllegalBoxException("Size must be greater than 1");
		h = height;
	}
	
	public int compareTo(Box other) {
		if(this.Volume() > other.Volume()) return 1;
		else if (this.Volume() < other.Volume()) return -1;
		return 0;
	}
	public String toString() { // Generates String representation of an object
		return ("L:"  + length + " W:" + width + " H:"  + height  + " (V:" + Volume()) + ")";
	}
	
	public boolean equals(Box other) { // Checks if the box sizes are the same.
		if (length == other.length
		&& width == other.width
		&& height == other.height) return true;
		return false; 		
	}
}
