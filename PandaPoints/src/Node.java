public class Node {
	
	private int index;
	private Node next;
	
	public Node(int idx, Node n) {
		index = idx;
		next = n;
	}
	
	public int getIndex() {
		return index;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node n) {
		next = n;
	}
	
}
