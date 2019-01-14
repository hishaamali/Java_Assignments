class PriorityQueue {
  PriorityQueueNode root;
  int size;

  public PriorityQueue() {
    root = null;
    size = 0;
  }

  // inserting a new node into the heap
  public void insert(HuffmanNode n) {
    PriorityQueueNode huffNode = new PriorityQueueNode(n);
    insert(huffNode);
  }

  public void insert(PriorityQueueNode n) {
    if (size == 0) {
      root = n;
      size++;
      return;
    }
    String path = path(size);
    if (path == null) return; 

    PriorityQueueNode itr = root;
    for (int i = 0; i < path.length() - 1; i++) {
      if (path.charAt(i) == 'L') {
        itr = itr.heapLeft;
      } 
      else {
        itr = itr.heapRight;
      }
    }
    if (path.endsWith("L")) { 
      itr.heapLeft = n;
      n.heapParent = itr;
    }
    else {
      itr.heapRight = n;
      n.heapParent = itr;
    }
    size++;
    itr = n;
    upBubbling(n);
  }


  // removing the min node from the heap
  public HuffmanNode removeMin() {
     if (size == 0) return null;
    HuffmanNode temp = root.data;
    if (size == 1) {
      size = 0;
      root = null;
      return temp;
    }
    PriorityQueueNode leaf = Node(size);
    swap(root, leaf);
    PriorityQueueNode parent = leaf.heapParent;
    if (leaf == parent.heapLeft) {
      parent.heapLeft = null;
    } else {
      parent.heapRight = null;
    }
    size--;
    PriorityQueueNode itr = root;
    downBubbling(root);
    return temp;
  }


  public void upBubbling(PriorityQueueNode itr){
    while (itr.heapParent != null) {
      if (itr.data.lowerCount(itr.heapParent.data)) {
        swap(itr, itr.heapParent);
      } else {
        break;
      }
      itr = itr.heapParent;
    }
  }


  public void downBubbling(PriorityQueueNode itr){
    int i;
    int left;
    int right;
    while (!itr.isLeaf()) {
      i = itr.data.count;
      if (itr.heapRight != null) {
        left = itr.heapLeft.data.count;
        right = itr.heapRight.data.count;
        if (left <= right && left < i) {
          swap(itr, itr.heapLeft);
          itr = itr.heapLeft;
        } 
        else if (right < left && right < i) {
          swap(itr, itr.heapRight);
          itr = itr.heapRight;
        } 
        else {
          break;
        }
      } 
      else if (itr.heapLeft != null) {
        left = itr.heapLeft.data.count;
        if (left < i) {
          swap(itr, itr.heapLeft);
          itr = itr.heapLeft;
        } 
        else {
          break;
        }
      } 
      else {
        break;
      }
    }
  }

  // peek at the min node from the heap but do not remove
  public PriorityQueueNode peekMin() {
    return root;
  }

  // helper function: swap the data of 2 nodes
  private void swap(PriorityQueueNode a, PriorityQueueNode b) {
    HuffmanNode temp = a.data;
    a.data = b.data;
    b.data = temp;
  }

  // helper function: find out the path to a position
  public String path(int position) {
    if (position < 1)
      return null;
    position++;
    String answer = "";
    while (position > 1) {
      if (position % 2 == 0) { // left branch
        answer = "L" + answer; // prepend
      } else { // right branch
        answer = "R" + answer;
      }
      position /= 2;
    }
    return answer;
  }

  // helper function: get a pointer to the node at the specified position
  public PriorityQueueNode Node(int position) {
    if (position < 0)
      return null;
    if (position == 0)
      return root;
    position--;
    String path = path(position);
    PriorityQueueNode iterator = root;
    for (int i = 0; i < path.length(); i++) {
      if (path.charAt(i) == 'L') {
        iterator = iterator.heapLeft;
      } else {
        iterator = iterator.heapRight;
      }
    }
    return iterator;
  }

  // helper function: print the entire heap inorder for easier debugging
  public void printHeap() {
    String[] s = { "Heap(inorder)=" };
    recursivePrintHeap(root, s);
    System.out.println(s[0]); // array is passed by reference, string is not
  }

  private void recursivePrintHeap(PriorityQueueNode n, String[] s) {
    // prints the heap in order
    if (n == null)
      return;
    recursivePrintHeap(n.heapLeft, s);
    s[0] += "(" + n.data.text + ":" + n.data.count + ")";
    recursivePrintHeap(n.heapRight, s);
  }
}
