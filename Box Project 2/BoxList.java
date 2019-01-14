
public abstract class BoxList {
    int length;
    BoxNode first;
    BoxNode last;
	public BoxList(){
		first = new BoxNode(null);
		last = first;
		length = 0;
		//creates a dummy node, point first last to the dummy node,
		// sets the length to 0
		
	}
	public void append(Box d) {				//adds the box node to the list
		   BoxNode tmp = new BoxNode(d);
		   this.last.next = tmp;
		   this.last = tmp;
		   this.length++;
	}
	
	public String toString() {		//converts the box list into a string
		BoxNode p = first.next;
		String returnString = "";
		while (p != null) {
			returnString += p.data + "\n";
			p = p.next;
		}
		return returnString;
	}
	
}