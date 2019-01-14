public class SortedBoxList extends BoxList {
	
	public SortedBoxList() {	// Constructor 
		super();
	}
	
	public void add(Box b) {
			BoxNode temp = new BoxNode(b);	// new node that will be in the list
			BoxNode lastNode = first;		// Box node for the previous node
			BoxNode nextNode = first.next;	//Box node for the next node
			
			
			while(nextNode!=null) { // loops until there is no nodes left
				if (nextNode.data.compareTo(temp.data)>0) break; // loop will stop if the next node is bigger than the new one
				lastNode=nextNode;			// if the next node is smaller, they will be switched 
				nextNode=nextNode.next;
			}
			
			lastNode.next = temp;	//inserts the new box into correct position
			temp.next=nextNode;
		
	}
	
}
