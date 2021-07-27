package problems_000_to_99;

import java.util.LinkedList;

public class AddTwoNumbers_2 {

	public static void main(String[] args) {
		

	}
	
    /**
     * Attempt 2 - July 27, 2021
     * 
     * SOLUTION OUTLINE:
     * - Loop over each list separately and store the values as a single integer
     * 	- Create pointers for each LinkedList, l1Cursor = l1 
     * 	- Initialize two integer variables to zero
     * 	- While loop to loop over the first linked list, while (l1Cursor != null)
     * 		- Val1 = Var1 * 10 + l1Cursor.val
     * 		- Increment the cursor
     * 	- Create a duplicate of the above loop for the second LinkedList
     * - Add the two integers together
     * 
     * 
     * - Store the integer as a LinkedList
     * 	- Initialize outputHead to the
     * 	- while (outputVal > 0),
     * 		- outputHead.val = outputVal % 10
     * 		- outputVal /= 10
     * 		- Increment outputHead
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
    	ListNode cursor1 = l1;
    	ListNode cursor2 = l2;
    	
    	int val1 = 0;
    	int val2 = 0;
    	
    	while (cursor1 != null) {
    		val1 = (val1 * 10) + cursor1.val;
    		cursor1 = cursor1.next;
    	}
    	
    	while (cursor2 != null) {
    		val2 = (val2 * 10) + cursor2.val;
    		cursor2 = cursor2.next;
    	}
    	
    	int outputVal = val1 + val2;
    	
    	// Reverse outputVal
    	int reversedOutput = 0;
    	
    	while (outputVal > 0) {
    		reversedOutput = (reversedOutput * 10) + outputVal % 10;
    		outputVal /= 10;
    	}
    	
    	ListNode outputHead = new ListNode();
    	
    	outputHead.val = reversedOutput % 10;
    	reversedOutput /= 10;
    	
    	ListNode outputCursor = new ListNode(); 
    	outputHead.next = new ListNode();
    	
    	while (reversedOutput > 0) {
    		outputHead.val = reversedOutput % 10;
    		reversedOutput /= 10;
    		outputHead.next = new ListNode();
    	}
    	return outputHead;
    }
	
	/**
	 * Attempt 1 - July 14, 2021 - DNF
	 * 
	 * SOLUTION OUTLINE:
	 * - Create two num variables (num1 and num2)
	 * - Pop each element off of the first linked list and add them to num1 until list1 is empty
	 * - Pop each element off of the second linked list and add them to num2 until list2 is empty
	 * - Add num1 and num2 (store answer in result variable)
	 * - Pop the last digit off of result and push it to a new linked list - continue until result <= 0
	 * - return output linked list
	 */
	
	
	/**
	 * Model Solution - WIP
	 */
	public static void addTwoNumbers_MS() {
		
	}

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
//class ListNode {
//	int val;
//	ListNode next;
//	ListNode() {}
//	ListNode (int val) { this.val = val; }
//	ListNode (int val, ListNode next) { this.val = val; this.next = next; }
//	
//}
