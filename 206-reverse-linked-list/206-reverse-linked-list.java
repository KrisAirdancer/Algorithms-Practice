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
     * IDEA: 
     * - Use recursion to travererse to the end of the linked list.
     *   On the way back up, pass the head node (last node) up the
     *   chain of recursion. On the way down, reverse the connections
     *   of the nodes by passing the previous head and the new head
     *   (head.next) down and on each iteration, connect the head
     *   to the next node's next pointer.
     * 
     * SOURCES:
     * - I followed this solution to arrive at mine: https://leetcode.com/problems/reverse-linked-list/discuss/58125/In-place-iterative-and-recursive-Java-solution
     */
    public ListNode reverseList(ListNode head) {
        // Pass in the given head as the oldHead and null as the newHead b/c the new list doesn't exist yet
        return recursiveReverseList(head, null);
    }
    
    private ListNode recursiveReverseList(ListNode oldHead, ListNode newHead) {
        // If the oldHead is null, we've reached the end of the list. Return the newHead.
        if (oldHead == null) {
            return newHead;
        }
        ListNode next = oldHead.next;
        oldHead.next = newHead;

        return recursiveReverseList(next, oldHead);
    }
}