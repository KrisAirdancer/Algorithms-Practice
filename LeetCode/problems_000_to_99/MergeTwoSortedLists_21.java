package problems_000_to_99;

public class MergeTwoSortedLists_21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	/**
	 * Attempt 1 - July 23, 2021
	 * 
	 * 
	 *Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public ListNode mergeSortedList_A1(ListNode l1, ListNode l2) {
		        
        ListNode output = null;
        ListNode outputHead = null;
        
        if (l1.val <= l2.val) {
            output = l1;
            outputHead = output;
            output = output.next;
            l1 = l1.next;
        } else if (l2.val <= l1.val) {
            output = l2;
            outputHead = output;
            output = output.next;
            l2 = l2.next;
        }
        
        while (l1.next != null || l2.next != null) { // Null - Null case
            
            if (l1 != null && l2 != null) { // l1 Not Null - l2 Not Null
                if (l1.val <= l2.val) {
                    output.next = l1;
                    l1 = l1.next;
                } else if (l2.val <= l1.val) {
                    output.next = l2;
                    l2 = l2.next;
                }
                
            } else if (l1 != null && l2 == null) { // l1 Not Null - l2 Null
                output.next = l1;
                l1 = l1.next;
                
            } else if (l1 == null && l2 != null) { // l1 Null - l1 Not Null
                output.next = l2;
                l2 = l2.next;
            }
            output = output.next;
        }
        return outputHead;
	}
}



//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//}
