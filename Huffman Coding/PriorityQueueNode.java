class PriorityQueueNode {
  HuffmanNode data;
  PriorityQueueNode heapLeft;
  PriorityQueueNode heapRight;
  PriorityQueueNode heapParent;

  public PriorityQueueNode(HuffmanNode data) {
    this.data = data;
  }

  public boolean isLeaf() {
    return (heapLeft == null && heapRight == null);
  }
}