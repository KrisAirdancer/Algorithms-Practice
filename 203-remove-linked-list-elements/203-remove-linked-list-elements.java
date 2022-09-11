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
    public ListNode removeElements(ListNode head, int val) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        ListNode newHead = new ListNode();
        newHead.next = head;
        
        ListNode currentNode = newHead;
        
        while (currentNode != null) {
            if (currentNode.next != null && currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            } else { // We don't iterate formally if we remove a node because removing a node effectively moves us forward by one.
                currentNode = currentNode.next;
            }
        }
        
        return newHead.next;
    }
}