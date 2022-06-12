/// <summary>
/// Remove Dups: Write code to remove duplicates from an unsorted linked list.
/// 
/// FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
/// </summary>
public class Solution {

    /// <summary>
    /// 
    /// IDEA:
    /// Loop over the linked list. For each item, store it in a HashSet. If an element
    /// is already present in the HashSet, remove it from the Linked List.
    /// 
    /// PERFORMANCE:
	/// Time Complexity: O(N)
	/// Memory Complexity: O(N)
    /// 
    /// OUTLINE: 
    /// Instantiate a generic HashSet
    /// Loop over the given linked list
    ///     If current item is in HashSet, remove it from the linked list (use helper method)
    ///     If current item is not in HashSet, add it to the HashSet
    ///
    /// SOURCES:
    /// 
    /// 
    /// </summary>
    public static void removeDups(LinkedListNode head) {
        
        HashSet<T> uniqueElements = new HashSet<T>();
        
        LinkedListNode currentNode = head;

        while (currentNode != null) {

            if (uniqueElements.Contains(currentNode.data)) {
                removeLinkedListNode(head, currentNode);
            } else {
                uniqueElements.Add(currentNode.data);
            }

            currentNode = currentNode.Next;
        }
    }

    private static void removeLinkedListNode(LinkedListNode head, LinkedListNode targetNode) {
        
        LinkedListNode currentNode = head;

        while (currentNode.Next != targetNode) {
            currentNode = currentNode.Next;
        }

        currentNode.Next = currentNode.Next.Next;
    }
}


public class LinkedListNode {
    // TODO: Implement the linked list node
}