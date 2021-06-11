package custom_linked_list;

public class CustomLinkedList {
	
	class Node {
		// Set the next node to null b/c there is no next node yet
		Node next = null;
		// This variable will hold our data - in this case it is of type int
		int data;
		
		/** Constructor to set up the node. In this case storing the passed value.
		 * 
		 * @param data The integer value to be stored in the node
		 */
		public Node(int data) {
			this.data = data;
		}
	}
	
	private Node head;
	private int size;
	
	/**
	 * Constructor for the linked list class
	 */
	public CustomLinkedList() {
		
	}

	/**
	 * Adds a node to the front of the list
	 */
	public void addToHead() {
		
	}
	
	/**
	 * Adds a node to the end of the list
	 */
	public void addToTail(int index, int value) {
		// Create a new node to attach to the end of the existing node (this node)
		Node end = new Node(value);
		// Saving a reference to the existing node (this node) for later use
		Node current = head;
		System.out.println(current);
		/*
		 * While the current next node (the node after this (the existing) node)
		 * isn't null - that is, there IS a next node - set this node equal to 
		 * the next one. Do this until you reach the end of the list where you
		 * then set the last node's "next" reference to the node that was just
		 * created and named "end" - this adds the new node to the end of the 
		 * linked list.
		 */
		while (current.next != null) {
			current = current.next;
			System.out.println("thisNode: " + current + ", thisNode.next: " + current.next);
		}
		current.next = end;
	}

	public void addAtIndex(int index, int value) {
		
	}
	
	/**
	 * Deletes the node at the specified index.
	 */
	public void deleteAtIndex(int index) {
		
	}
	
	/**
	 * Returns the value of the index-th node in the linked list. Returns -1 if index is invalid.
	 */
	public void getValue(int index) {
		
	}
}
