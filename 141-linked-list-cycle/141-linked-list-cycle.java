/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    /**
     * IDEA:
     * - Use two pointers to loop over the linked list. One pointer moves at twice the speed of the other.
     * If the faster pointer catches up with the slower pointer, there is a cycle. If the faster pionter reaches
     * a `null` node, there isn't a cycle.
     */
    public boolean hasCycle(ListNode head) {
        
        if (head == null) { return false; }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (fast != null) {
            
            // fast catches slow, there is a loop.
            if (fast == slow) {
                return true;
            }
            
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                fast = fast.next;
            }
            
            slow = slow.next;
        }
        
        return false;
    }
}