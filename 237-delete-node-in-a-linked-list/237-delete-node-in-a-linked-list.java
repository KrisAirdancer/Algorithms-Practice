/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /**
     * IDEA:
     * - Don't remove the specified node. Instead, shift the values of all of the nodes
     *   back by one and then remove the last node in the list. That is, the falue of the
     *   specified node gets set to the value of the next node, the value of the next node
     *   gets set to the value of the node after it, and so on.
     * 
     * PERFORMANCE:
     * Time Complexity: O(N) where N is the number of nodes in the list b/c  we may have to
     *                  remove the first node in the list, in which case we will have to
     *                  traverse the entire list.
     * Memory Complexity: O(N) b/c we only have to store the original linked list. No extra
     *                    memory is needed. No recursion, so no more than a single call
     *                    will be added to the call stack.
     * 
     * OUTLINE: 
     * - Loop while the current.next.next != null
     *     - Replace current.val with current.next.val
     *     - Step forward one node
     * - Replace current.val with current.next.val
     * - Set current.next = null
     * 
     */
    public void deleteNode(ListNode node) {
        
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        
        node.val = node.next.val;
        node.next = null;
    }
}