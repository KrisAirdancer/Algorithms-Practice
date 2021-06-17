package problems_700_to_799;

public class DesignLinkedList_707_A1 {

	private Node head; // Instance variable to store a reference to the head node of this LinkedList
	private int size; // Instance variable to store the number of nodes currently in this LinkedList
	
	class Node {
		// Instance variable to store the value stored in this node
		int data;
		/* An instance variable that declares, but does NOT create (initialize),
		 * a variable of type Node that will store a reference to the node that
		 * comes after (the next node) this node object. */
		Node next;
		// Constructor to initialize the data variable of the new Node
		public Node(int data) {
			this.data = data;
		}
	}
	
	 /** Initialize your data structure here. */
	public DesignLinkedList_707_A1() {
		// I don't think I need to initialize anything here
	}
	
    /** Get the value of the index-th node in the linked list.
     * If the index is invalid, return -1.
     * 
     * Time Complexity: O(n), linear time, where n is the number of nodes in the list
     * - Have to loop over the list to get to the desired node
     */
    public int get(int index) {
        // Check for invalid index
    	if (index < 0 || index >= size) {
    		return -1;
    	}
    	
    	Node current = head;
    	    	
    	for (int i = 0; i < index; i++) {
    		// Update the pointer
    		current = current.next;
    	}
    	return current.data;
    }
	
    /** Add a node of value val before the first element of the linked list.
     * After the insertion, the new node will be the first node of the linked list.
     * 
     * Time Complexity: O(1), constant time
     * */
    public void addAtHead(int val) {
    	// Create a new Node object to be added to the LinkedList
    	Node newNode = new Node(val);
    	// Set the new Node's next variable to reference the current head Node of the LinkedList
    	newNode.next = head;
    	// Set the head Node to the newly added Node
    	head = newNode;
    	// Increment the size variable
    	size++;
    }
	
    /** Append a node of value val to the last element of the linked list.
     * 
     * Time Complexity: O(n), linear time, where n is the number of nodes in the LinkedList
     * - Has to iterate through the entire
     * LinkedList (all of the nodes) to find the Tail node.
     */
    public void addAtTail(int val) {
    	// Create a new Node object to be inserted at the end of the LinkedList
    	Node newNode = new Node(val);
    	// Increment the size variable
    	size++;
    	// If the list is empty, make the new node the head
    	if (head == null) {
    		head = newNode;
    	} else {
	    	// Create a temporary Node object to store a reference to the current node - a pointer
	    	Node current = head; // Start at the first node in the list - the head node
	    	/* Iterate through the linked list until the tail node is found
	    	 * The tail node will have a next node variable of null - it won't reference another node */
	    	while (current.next != null) {
	    		current = current.next; // Set the pointer to the next node in the list
	    	}
	    	// Set the next node of the current node (the Tail node) to the new node
	    	current.next = newNode;
    	}
    }
    
    /** Add a node of value val before the index-th node in the linked list.
     * If index equals to the length of linked list, the node will be appended
     * to the end of linked list. If index is greater than the length, the
     * node will not be inserted.
     * 
     * Time Complexity: O(n), linear time, where n is the number of elements in the list
     * - Have to loop over each node in the list until the correct node is found.
     */
    public void addAtIndex(int index, int val) {	
        // Check for invalid index
    	if (index < 0 || index > size) {
    		return;
    	}
    	// If user selects to insert node at beginning of list, insert it as the head
    	if (index == 0) {
    		addAtHead(val);
    	} else {
    		// Increment size
    		size++;
	    	// Create the new node to be inserted
	    	Node newNode = new Node(val);
	    	// Create two pointer to track our location in the list
	    	Node current = head; // We start our pointer at the second item in the index
	    	// Loop over the list until the node at the specified index is reached
	    	for (int i = 0; i < index - 1; i++) { // index ends at index - 1 b/c we want to insert our new node just before the node that is currently at the specified index, pushing the old node up one and placing the new node at the index
	    		current = current.next;
	    	}
	    	// Insert the new node
	    	newNode.next = current.next;
	    	current.next = newNode;
    	}
    }
    
    /** Delete the index-th node in the linked list, if the index is valid.
     *
     * Time Complexity: O(n), linear, where n is the number of items in the list.
     * - We have to loop over a large portion of the list to reach the desired index.
     */
    public void deleteAtIndex(int index) {
        // Check for invalid index
    	if (index < 0 || index >= size) {
    		return;
    	} 
    	// Decrement size variable
    	size--;
    	// Create pointer
    	Node current = head;
    	// Loop over the list until the node just before the one to be removed is found
    	for (int i = 0; i < index - 1; i++) { // Index ends at index - 1 b/c we want to stop at the node just before the one to be removed 
    		// Update pointers
    		current = current.next; // When loop exits, current should be the node just before the one to be removed
    	}
    	// Link the current node (the one before the node that is to be removed) to the node after the node to be removed
    	current.next = current.next.next;
    	
    }
    
    @Override
    public String toString() {
    	
    	String output = "[";
    	
    	Node current = head;
    	
    	while (current != null) {
    		output = output + current.data;
    		current = current.next;
    		if (current != null) {
    			output = output + ", ";
    		}
    	}
    	
    	output = output + "]";
    	
    	return output;
    }
    
	public static void main(String[] args) {
		
		DesignLinkedList_707_A1 myLinkedList = new DesignLinkedList_707_A1();
		myLinkedList.addAtHead(1); // linked list becomes 1
		System.out.println(myLinkedList);
		myLinkedList.addAtTail(3); // linked list becomes 1->3
		System.out.println(myLinkedList);
		myLinkedList.addAtIndex(1, 2); // linked list becomes 1->2->3
		System.out.println(myLinkedList); 
		myLinkedList.get(1);              // return 2
		System.out.println(myLinkedList);
		myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
		System.out.println(myLinkedList);
		myLinkedList.get(1);              // return 3
		System.out.println(myLinkedList);
		
		// Testing toString() method
//		myLinkedList.addAtTail(1);
//		myLinkedList.addAtTail(2);
//		myLinkedList.addAtTail(3);
//		myLinkedList.addAtTail(4);
//		myLinkedList.addAtTail(5);
//		myLinkedList.addAtTail(6);
//		System.out.println(myLinkedList.toString());
		
		// Testing addAtIndex() method
//		myLinkedList.addAtIndex(4, 10); // Should get: [1, 2, 3, 4, 10, 5, 6]
//		System.out.println(myLinkedList);
	}
	/**
	 * Your MyLinkedList object will be instantiated and called as such:
	 * MyLinkedList obj = new MyLinkedList();
	 * int param_1 = obj.get(index);
	 * obj.addAtHead(val);
	 * obj.addAtTail(val);
	 * obj.addAtIndex(index,val);
	 * obj.deleteAtIndex(index);
	 */
}
