# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        rHead = ListNode()
        rHead.next = head

        left = rHead
        right = head

        for i in range(n): # For n = 2, range(n) yields 0, 1 (it loops twice)
            right = right.next

        while right: # Loop until right is None/Null to position the left pointer at the node just before the target node
            right = right.next
            left = left.next

        # Remove the target node (note: left currently points to the node just before the target node)
        left.next = left.next.next

        return rHead.next # Neet to return the real head, not the dummy head.

# ***** INPUTS *****
# > The head of a linked list from which we are to remove a node.
# > An integer n that specifies the INDEX OF the node to be removed from the linked list.
# ***** OUTPUTS *****
# > The head of the linked list that the node has been removed from.
#   > Should be the same pointer as was passed in as "head"
# ***** IDEAS *****
# > Idea 1:
#   > Create a dummy head and link it to the input list's head.
#   > Step over the list until current.next is the node to be removed.
#   > Remove the target node then break out of the loop and return the head.
#   > Oops. This won't work. I misread the question. We need to remove the nth from the end. Not the one with the value n.
# > Idea 2:
#   > The trick to this problem is figuring out where the node to be removed is.
#     > To do this in two passes, we can use the first pass to count the number of nodes, then use the second pass to step to the position we want: length - n.
#     > To do this in a single pass, we can use two pointers to step over the list. We set the right pointer to be n places away from the left pointer. When the right pointer reaches the end of the list, the left pointer will be at the node to be removed.
#   > Edge Case: What about lists of length 1 or 0? We can't step the right pointer past the end of the list by more than a single node.
#     > ...
#   > Edge Case: For lists of any length, if we have an "n" value that specifies the first node in the list, we will loop out of bounds (null pointer) when setting up the right pointer.
#     > This can be solved with the dummy head.
#     > If we add a dummy head to the front of the list, we can start left at the dummy node and right at the real head, then loop n times to set the position of the right pointer.
#     > This will setup both pointers in such a way that we don't have to loop n + 1 times. This means that we 
# ***** OUTLINE/PSEUDO-CODE *****
# > Instantiate a dummy head rHead and connect it to the front of the list.
# > Instantiate two pointers: left (rHead) and right (head) -- (right is shifted forward one place to position left on the node before the one to be removed.)
# > Loop to move the right pointer to the correct position (loop n times)
# > Loop until right is None:
#   > Step both pointers (left and right) forward at the same pace
# > Remove the target node
# > Return rHead.next

