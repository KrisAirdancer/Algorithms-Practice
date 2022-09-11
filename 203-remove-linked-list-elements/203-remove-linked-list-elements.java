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
     * PERFORMANCE:
     * - O(N) time complexity - We iterate over each node in the list only once; therefore, O(N).
     * - O(N) space complexity - We don't duplicate the list, so we only need to store the original. Thus, O(N).
     * 
     * SOURCES:
     * - I worked through this solution/guide to reach my solution: https://leetcode.com/problems/remove-linked-list-elements/discuss/1572932/Java-Three-Simple-and-Clean-solutions-w-Explanation-or-Iterative-and-Recursive-or-Beats-100 
     */
    public ListNode removeElements(ListNode head, int val) {
        // If list is empty
        if (head == null) {
            return null;
        }
        
        ListNode tempHead = new ListNode();
        // We add a new node to the beginning of the LinkedList to allow us to easily check and remove the first node (head) if head.val == val
        tempHead.next = head;
        
        ListNode currentNode = tempHead;
        
        while (currentNode != null) {
            
            if (currentNode.next != null && currentNode.next.val == val) {
                currentNode.next = currentNode.next.next;
            } else { // We don't iterate formally if we remove a node because removing a node effectively moves us forward by one.
                currentNode = currentNode.next;
            }
        }
        // We return the node after tempHead b/c tempHead was just a temporary node to make it easy to remove the head node if needed. The real head is tempHead.next
        return tempHead.next;
    }
}