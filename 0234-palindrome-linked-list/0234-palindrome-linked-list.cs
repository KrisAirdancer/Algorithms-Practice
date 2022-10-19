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
    
    /**
     * IDEA:
     * - If a sequence is a palindrome, the reverse of the second half of the list will be the
     *   same as the first half of the list, or vice-versa. Thus, we can loop over the linked list
     *   and store each element in an array until we reach the middle, then begin comparing
     *   each item in the linked list after the midpiont with each item in the array, but loop
     *   over the array in reverse, we will be able to determine if it is a palindrom.
     * - This can be optimized by reversing the first half of the linked list as we traverse to
     *   the middle of the linked list. Then, since we will still have a pointer to the head
     *   of the list, we can compare the first, reversed, half of the list to the second
     *   half. This will remove the need for a secondary data structure to house the reversed list.
     *
     * EDGE CASES:
     * - Finding the midpoint of an odd-length list.
     *     - The middle element will need to be skipped so that the comparision doesn't end up
     *       off by one. The middle element is, by itself, a palindrome.
     * 
     * PERFORMANCE:
     * - Time Complexity: O(N) - Since we only need to loop over the linked list once, it will
     *                    take only N steps, where N is the number of elements in the linked list,
     *                    to do so. Thus, O(N).
     * - Memory Complexity: O(1) - Since we can reverse the first half of the linked list as we
     *                      traverse to the middle, we won't need additional data structures or
     *                      duplicate data. Thus, we only need to store the original linked list.
     *                      Thus, O(1).
     */
    public bool IsPalindrome(ListNode head) {
        
        // Copy head to array list
        
        // Run two pointers towards each other from the head and end of the list
            // If the pointers are not equivalent, return false
        
        IList<int> copy = new List<int>();
        
        ListNode current = head;
        
        while (current != null) {
            copy.Add(current.val);
            current = current.next;
        }
        
        int left = 0;
        int right = copy.Count - 1;
        
        while (left <= right) {
            Console.WriteLine($"left: {left}, right: {right}");
            Console.WriteLine($"copy[left]: {copy[left]}, copy[right]: {copy[right]}");
            
            int cLeft = copy[left];
            int cRight = copy[right];
            Console.WriteLine($"cLeft: {cLeft}, cRight: {cRight}");
            
            if (cLeft != cRight) {
                Console.WriteLine("Returning");
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
}


























