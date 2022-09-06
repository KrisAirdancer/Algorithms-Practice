/**
 * Definition for singly-linked list.
 * public class ListNode {
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
     * - Create two pointers to loop over both lists simultaneously. When a pointer reaches the
     * end of either list, it starts again at the beginning of the other list. Once this has
     * happened for both pointers, if the lists a joined, they pointers will meet at the
     * intersection. If the lists are NOT joined, they will reach a null node at the same time.
     * 
     * PERFORMANCE:
     * - O(m + n) time complexity where m is the length of list A and n is the length of list B. O(m + n) because
     * this solution loops over both lists just once as if they are connected end-to-end. That is,
     * it loops over each node in both lists once; thus, O(m + n) iterations.
     * - O(1) space complexity because no additional space is used. The pointers loop over the original
     * lists and no extra data is stored to check for an intersection.
     * 
     * OUTLINE: 
     * - Create two pointers - one at each head
     * - Loop: While both pointers != null
     *     - If pointers are pointing to same node,
     *         - Return "true" (the current node)
     *     - If pointerA is null,
     *         - pointerA = headB
     *     - If pointerB is null,
     *         - pointerB = headA
     *     - Increment pointers
     * - Return "false" (null)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        while (pointerA != pointerB) {
            
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }
            
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }
        return pointerA;
    }
}