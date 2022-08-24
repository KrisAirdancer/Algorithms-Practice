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
class Solution {
    
    /**
     * Create a new linked list (LL) to be returned
     * Add the first element in the given LL to the new LL
     * Loop (over entire given LL):
     *    If the current element in the given LL is the same as the element most recently added to the new LL, move to the next elemnet in the given LL.
     *    If the current element in the given LL is different than the element most recently added to the new LL, add the element to the new LL.
     * Return the head of the new linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) {
            return head;
        }
        
        ListNode returnHead = new ListNode(head.val);
        ListNode returnPosition = returnHead;
        ListNode givenPosition = head.next;
        
        // System.out.println("returnHead: " + returnHead.val + ", returnPosition: " + returnPosition.val + ", head: " + head.val + ", givenPosition: " + givenPosition.val);
        
        while (givenPosition != null) {
                    // System.out.println("returnHead: " + returnHead.val + ", returnPosition: " + returnPosition.val + ", head: " + head.val + ", givenPosition: " + givenPosition.val);
            
            if (givenPosition.val != returnPosition.val) {
                returnPosition.next = new ListNode(givenPosition.val);
                returnPosition = returnPosition.next;
            }
            givenPosition = givenPosition.next;
        }
        
        return returnHead;
    }
}