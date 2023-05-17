# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: Optional[ListNode]) -> bool:
        if head is None:
            return False

        slow = head
        fast = head

        while fast and fast.next: # fast.next must exist for us to be able to do fast.next.next in the loop. If it isn't, we'll get a null pointer error.
            slow = slow.next
            fast = fast.next.next
            # We check to see if the pointers have caught each other after stepping them forward b/c we are starting the two pointers at the same position and if we checked them first, we would always return true once we enter the loop.
            if fast == slow:
                return True

        return False

# **** IDEAS *****
# > Loop over the list with a fast and slow pointer. If the fast pointer catches the slow pointer, then there is a cylce. If the fast pointer reaches a Null node, there is not a cycle.
# > Note that there cannot be a cycle embedded in the middle of a linked list (a cycle and a null terminating node) b/c this is a linked list, not a graph. Therefore, each node can have only one link to a following node.