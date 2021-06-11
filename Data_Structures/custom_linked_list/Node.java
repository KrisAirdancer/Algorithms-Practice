package custom_linked_list;

public class Node {
	// Set the next node to null b/c there is no next node yet
	Node next = null;
	// This variable will hold our data - in this case it is of type int
	int data;
	
	// Constructor to set up the node. In this case storing the passed value.
	public Node(int data) {
		this.data = data;
	}
	
	void addToEnd(int data) {
		// Create a new node to attach to the end of the existing node (this node)
		Node end = new Node(data);
		// Saving a reference to the existing node (this node) for later use
		Node thisNode = this;
		System.out.println(thisNode);
		/*
		 * While the current next node (the node after this (the existing) node)
		 * isn't null - that is, there IS a next node - set this node equal to 
		 * the next one. Do this until you reach the end of the list where you
		 * then set the last node's "next" reference to the node that was just
		 * created and named "end" - this adds the new node to the end of the 
		 * linked list.
		 */
		while (thisNode.next != null) {
			thisNode = thisNode.next;
			System.out.println("thisNode: " + thisNode + ", thisNode.next: " + thisNode.next);
		}
		thisNode.next = end;
	}
}
