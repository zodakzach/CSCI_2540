package Activity10;

public class Node {
	int item;
	Node next;
	
	public Node(int item) {
		this.item = item;
		next = null;
	}
	
	public Node(int item, Node next) {
		this.item = item;
		this.next = next;
	}

}
