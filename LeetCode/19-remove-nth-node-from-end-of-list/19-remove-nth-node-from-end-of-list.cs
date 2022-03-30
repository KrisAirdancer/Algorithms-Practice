/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Create two pointers: start one at index n+1 (right) and the other at
    /// index 0 (left). Traverse the list using both pointers at a speed of
    /// 1 node/iteration. When the right pointer reaches the end of the
    /// list, the left pointer will be one node before the one to be removed.
    /// Next, remove the target node and return the head of the list.
    /// 
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// Create two pointers: left at 0 and right at n + 1
    /// Loop over the list until right reaches the end of the list
    /// Remove the target node
    /// Return the head of the list
    /// 
    /// 
    /// </summary>
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
        
        ListNode left = head;
        ListNode right = head;
        
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        
        if (right is null) { return head.next; }
        
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        
        left.next = left.next.next;
        
        return head;
    }
}