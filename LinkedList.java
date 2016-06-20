package linkedlist;

/**
 * An implementation of a linked list of integers.
 * 
 * @author  Keshav Saharia
 * 			keshav@techlabeducation.com
 */
public class LinkedList {
	
	// Stores a reference to the first node in the list.
	Node first;
	
	/**
	 * Adds the given integer to the linked list.
	 * @param number - the number to add to the list
	 */
	public void add(int number) {
		// Create a new node that contains the number as a value.
		Node newNode = new Node(number);
		
		// If there is no first node, the first node becomes the 
		// new node that was just created.
		if (first == null) {
			first = newNode;
		}
		// Otherwise, iterate to the last node in the list, and add the
		// new node as the next node of the last node.
		else {
			// Start at the first node
			Node current = first;
			
			// While the current node has a next node, go to the next node
			while (current.next != null) {
				current = current.next;
			}
			
			// Once you are at the last node, set its next reference to the
			// new node that was just created.
			current.next = newNode;
		}
	}
	
	/**
	 * Prints out the linked list.
	 */
	public void print() {
		// Start at the first node.
		Node current = first;
		
		// While the node being referenced is a valid (non-null) node.
		while (current != null) {
			// Print out it's value.
			System.out.print(current.value);
			
			// If it is not the last node, print a comma after the value.
			if (current.next != null) {
				System.out.print(", ");
			}
			
			// Go to the next node.
			current = current.next;
		}
	}
	
	/**
	 * Returns true if the linked list contains the given number, and false otherwise.
	 * @param number - the number to test
	 * @return true if the number is in the list, and false otherwise
	 */
	public boolean contains(int number) {
		// Start at the first node in the list
		Node current = first;
		
		// While the node being referenced is a valid (non-null) node.
		while (current != null) {
			// Check if the value of this node is the number being tested.
			if (current.value == number) {
				return true;
			}
			
			// Go to the next node
			current = current.next;
		}
		
		// Return false if no node matched the test number
		return false;
	}
	
	/**
	 * Returns the value for the node at the given index.
	 * @param index - the index of the element in the linked list
	 * @return the value of the element
	 */
	public int get(int index) {
		// Check for a valid non-negative index.
		if (index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		// Start at the first node
		Node current = first;
		
		// Index # of times, go to the next node.
		for (int i = 0 ; i < index ; i++) {
			// If we reach the end of the list before reaching this element
			if (current == null) {
				throw new IndexOutOfBoundsException();
			}
			// Go to the next element
			current = current.next;
		}
		
		//  Return the value of the current node.
		return current.value;
	}
	
	/**
	 * Removes the node from the given index in the list.
	 * @param index - the index to remove
	 * @return the value that was removed
	 */
	public int remove(int index) {
		// Removing the first element involves pointing the "first" reference to the
		// next node after the first one.
		if (index == 0) {
			// Reference to the first node
			Node removeThis = first;
			// Set the second node as the new first one
			first = first.next;
			// Return the value of the node that was removed
			return removeThis.value;
		}
		// Removing any other element involves iterating to the element before, and setting
		// its "next" reference to the node after it.
		else {
			// Start at the first node
			Node current = first;
			
			// Iterate to the node before the one to be removed
			for (int i = 0 ; i < index - 1 ; i++) {
				current = current.next;
			}
			
			// Set current's next reference to the node after the one being removed
			Node removeThis = current.next;
			// The node after the one being removed
			Node after = removeThis.next;
			
			// Set the reference of current.next to the node after
			current.next = after;
			
			// Return the value of the node that was removed
			return removeThis.value;
		}
	}
	
	/**
	 * Returns the size of the linked list.
	 */
	public int size() {
		// Refer to the first node
		Node current = first;
		// Count the number of nodes
		int count = 0;
		
		// While the node being referenced is a real node
		while (current != null) {
			// Add one to the count of nodes
			count = count + 1;
			
			// Refer to the next node
			current = current.next;
		}
		
		// Return the number of nodes
		return count;
	}
	
}
