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
     * IDEA(s):
     * Naive Solution:
     * - Loop over each linked list, convert the numbers into strings, parse the
     *   strings as integers, add theh integers, then convert the integers into
     *   a linked list to be returned.
     * - WON'T WORK: Max int (in Java) is ~2 billion. That's 9 digits. We'll get
     *   an overflow b/c this solution must accept values with up to 100 digits.
     * Beter Solution:
     * - Loop over both linked lists simultaneously. On each iteration, add the
     *   two values 
     * 
     * OUTLINE:
     * - While l1 OR l2 is not null
     *     - if 
     * 
     */ 
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode emptyHead = new ListNode();
        ListNode current = emptyHead;
        
        ListNode p1 = l1;
        ListNode p2 = l2;
        
        int sum = 0;
        int carry = 0;
        
        while (p1 != null || p2 != null || carry > 0) {
            
            int val_1 = 0;
            int val_2 = 0;
            
            if (p1 != null) {
                val_1 = p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val_2 = p2.val;
                p2 = p2.next;
            }

            sum = val_1 + val_2;
            sum += carry;
            carry = 0;
            System.out.println("First :: sum: " + sum + ", carry: " + carry);
            if (sum >= 10) {
                carry = (sum / 10);
                sum = (sum % 10);
            }
            System.out.println("Second :: sum: " + sum + ", carry: " + carry);
            current.next = new ListNode(sum);
            current = current.next;
        }
        
        return emptyHead.next;
    }
}