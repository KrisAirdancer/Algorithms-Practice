package custom_linked_list;

/**
 * LeetCode 707 - Design Linked List
 * @author Chris Marston
 *
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 * Implement the MyLinkedList class:
 * 
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 * 
 * Example 1:
 * 
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 * 
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *  
 *  
 * Constraints:
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 *
 */

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
		this.head = null; // Setting the head to null upon initialization (there aren't any nodes yet)
		this.size = 0; // Size set to zero upon initialization (there aren't any nodes yet)
	}

	/**
	 * Adds a node to the front of the list
	 */
	public void addToHead(int value) {
		Node current = this.head;
		Node newNode = new Node(value);
		newNode.next = current;
		this.head = newNode;
		size++;
	}
	
	/**
	 * Adds a node to the end of the list
	 */
	public void addToTail(int value) {
		
		// TODO Add code to call addToHead() if the linked list has length of zero (it contains no nodes, meaning the node being added will be the list's head)
		
		// Create a new node to attach to the end of the existing node (this node)
		Node end = new Node(value);
		// Saving a reference to the existing node (this node) for later use
		Node current = head;
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
		}
		current.next = end;
		this.size++; // Incrementing the size variable of the linked list
	}

	public void addAtIndex(int index, int value) {
		
	}
	
	/**
	 * Deletes the node at the specified index.
	 */
	public void deleteAtIndex(int index) {
		
	}
	
	/**
	 * Returns the value of the index-th node in the linked list.
	 * Returns -1 if index is invalid.
	 */
	public int getValue(int index) {
		/* TODO List
		 * IDEA: Loop over the list until the index-th node is reached, then return
		 * the value of that node.
		 */
		
		// If the index isn't in the linked list, return -1
		if (index > this.size - 1 || index < 0) {
			return -1;
		}
		// Create a variable to hold the node currently being checked
		Node current = head;
		
		for (int i = 0; i <= this.size; i++) {
			// If desired node is found, return its stored value.
			if (i == index) {
				return current.data;
			}
			current = current.next;
		}
		return -1; // If the index isn't found in the list, return -1 (TODO This is redundant with the if statement at the beginning of this method. Figure out how to remove one or the other.)
	}
	
	/**
	 * Checks if the linked list is empty or not.
	 * 
	 * @return true if there are no nodes in the linked list, false otherwise.
	 */
	public boolean isEmpty() {
		return true; // Temp return
	}

	@Override
	public String toString() {
		
		// If the linked list is empty (has no nodes) return empty brackets
		if (this.size == 0) {
			return "[]";
		}
		
		String output = "[";
		Node current = head;
		// Add each node's stored value to the output string
		while (current.next != null) {
			output = output + current.data + ", ";
			current = current.next;
		}
		output = output + current.data + "]";
		return output;
	}
}
