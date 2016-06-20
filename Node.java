package linkedlist;

/**
 * Represents a single node in the linked list.
 * @author  Keshav Saharia
 * 			keshav@techlabeducation.com
 */
public class Node {
	// The value being stored by the node
	int value;
	// Reference to the next node
	Node next;
	
	/**
	 * Constructs this node with the given value.
	 * @param value - the value stored in this node
	 */
	public Node(int value) {
		this.value = value;
	}
}
