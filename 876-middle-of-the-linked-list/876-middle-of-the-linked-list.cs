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
    /// Use two pointers to loop over the list. If one moves at twice the speed
    /// of the other, it will traverse the entire list in the same time it will
    /// take the slower one to traverse half of the list. Thus, we will have
    /// found the middle of the list.
    /// 
    /// This should also result in the second of any two middle nodes being
    /// returned. That is, if the list has an even number of nodes, it will
    /// have two middle nodes. This method will return the second of those
    /// two nodes. As is requested by this problem.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// Initialize two pointers: fast and slow
    /// Loop over the list until fast reaches the end of the list,
    /// Return slow
    /// 
    /// </summary>
    public ListNode MiddleNode(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null) {
            
            if (fast.next.next == null) {
                fast = fast.next;
                slow = slow.next;
            } else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return slow;
    }
}