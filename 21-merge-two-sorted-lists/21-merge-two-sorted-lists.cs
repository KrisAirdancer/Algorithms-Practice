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
    /// Store the head of the node with the smaller value (make sure to increment the associated pointer).
    /// Then loop over the nodes of each list using two pointers (one for each list). On each iteration,
    /// compare the values of the two current nodes and add the smaller of the two to the return list. Continue
    /// until the entirety of both lists have been added to the return list. Then return the head of the return list.
    /// 
    /// If a list is empty, just return the non-emty one. If both are empty, return the head of list1.
    /// 
    /// Loop and compare only while both lists are non-empty. As soon as one is empty, just loop over the other
    /// and add all of the remaining items to the return list. This can be done as part of the primary loop.
    /// 
    /// PERFORMANCE:
	/// Time Complexity: O(N)
    /// Memory Complexity: O(N)
    /// 
    /// OUTLINE: 
    /// If both lists are empty. If so, return list1.head
    /// If list1 is emtpy, return list2.head
    /// If list2 is empty, return list1.head
    /// 
    /// Create two Node pointers and initialize them to the first node in each list
    /// Store the larger of the two heads as a separate Node variable
    ///     Increment the Node pointer associated with the node that was stored
    ///     Initialize a new pointer called current to the head of the node that was just stored
    /// 
    /// Loop over the lists using the pointers
    ///     If one node is larger than the other, add it to the head that was stored earlier
    ///         Increment the node pointer associated with the node that was stored
    /// Return the head of the result list
    /// 
    /// </summary>
    public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
                
        // Check for empty lists
        if (list1 == null && list2 == null) {
            return list1;
            
        } else if (list1 == null) {
            return list2;
            
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode pointer_1 = list1;
        ListNode pointer_2 = list2;
        ListNode returnHead;
        
        // Store the head of the return list
        if (pointer_1.val <= pointer_2.val) {
            returnHead = new ListNode(pointer_1.val, pointer_1.next);
            pointer_1 = pointer_1.next;
            
        } else {
            returnHead = new ListNode(pointer_2.val, pointer_2.next);
            pointer_2 = pointer_2.next;
        }
        
        ListNode insertionNode = returnHead;
        
        while (pointer_1 != null || pointer_2 != null) { // Once both nodes are null, we've visited every node in each list.

            if (pointer_1 != null && pointer_2 != null) {

                if (pointer_1.val <= pointer_2.val) {
                    insertionNode.next = new ListNode(pointer_1.val, pointer_1.next);
                    insertionNode = insertionNode.next;
                    pointer_1 = pointer_1.next;

                } else {
                    insertionNode.next = new ListNode(pointer_2.val, pointer_2.next);
                    insertionNode = insertionNode.next;
                    pointer_2 = pointer_2.next;
                }
            } else if (pointer_1 != null) {
                insertionNode.next = new ListNode(pointer_1.val, pointer_1.next);
                insertionNode = insertionNode.next;
                pointer_1 = pointer_1.next;
                
            } else if (pointer_2 != null) {
                insertionNode.next = new ListNode(pointer_2.val, pointer_2.next);
                insertionNode = insertionNode.next;
                pointer_2 = pointer_2.next;
            }
        }
        
        return returnHead;
    }
}














