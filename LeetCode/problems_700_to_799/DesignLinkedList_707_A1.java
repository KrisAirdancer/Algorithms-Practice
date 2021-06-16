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
    	if (index < 0) {
    		return -1;
    	}
    	
    	Node current = head;
    	    	
    	while (index > 0 && current.next != null) {
    		// Update the pointer
    		current = current.next;
    		// Decrement the index
    		index--;
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
    	if (index < 0) {
    		System.out.println("Invalid index.");
    		return;
    	}
    	// If user selects to insert node at beginning of list, insert it as the head
    	if (index == 0) {
    		addAtHead(val);
    	}
    	// Create the new node to be inserted
    	Node newNode = new Node(val);
    	// Create two pointers to track our location in the list
    	Node previous = head;
    	Node current = head.next;
    	
    	index--; // Decrement the index by one b/c we are starting current at index = 1
    	// Loop over the list until the node at the specified index is reached
    	while (index > 0 && current.next != null) {
    		// Shift pointers
    		previous = current;
    		current = current.next;
    		// Decrement index to keep track of our location
    		index--;
    	}
    	// Insert the new node
    	newNode.next = current;
    	previous.next = newNode;
        
    }
    
    /** Delete the index-th node in the linked list, if the index is valid.
     *
     * Time Complexity: O(n), linear, where n is the number of items in the list.
     * - We have to loop over a large portion of the list to reach the desired index.
     */
    public void deleteAtIndex(int index) {
        // Check for invalid index
    	if (index < 0) {
    		System.out.println("Invalid index.");
    		return;
    	}    	
    	// Create two pointers
    	Node previous = head;
    	Node current = head.next;
    	// Decrement the index b/c our current pointer is starting at index = 1
    	index--;
    	// Loop over the list until the specified index is found
    	while (index > 0) {
    		// Update pointers
    		previous = current;
    		current = current.next;
    		// Decrement the index
    		index--;
    	}
    	// Remove the found node
    	previous = current.next; // Connect the node before the deleted node to the node after the deleted node
    	current.next = null; // Clear out the next variable in the deleted node
    	
    }
    
	public static void main(String[] args) {
		
		DesignLinkedList_707_A1 obj = new DesignLinkedList_707_A1();
		obj.addAtHead(90);
		int param_1 = obj.get(0);
		obj.addAtTail(70);
		obj.addAtIndex(4, 20);
		obj.deleteAtIndex(3);

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
