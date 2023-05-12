# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        """
        Do not return anything, modify head in-place instead.
        """

        current = head
        nodes = []

        while current:
            nodes.append(current)
            current = current.next

        left = 1
        right = len(nodes) - 1
        current = head

        while left <= right: # May need to handle this case differently to make sure the last node get's added correctly. <= maybe?
             current.next = nodes[right]
             right -= 1
             current = current.next

             current.next = nodes[left]
             left += 1
             current = current.next 
        
        current.next = None

# ***** IDEAS *****
# BFSol:
# > Step over the list and for each node either connect the next node in the list or step to the end of the list with a second pionter and add the node at the end of the list to the current position (.next that is).
# > This will work, but it will take O(N^2) time, which is not so great.
# Idea 1:
# > Step over the input list to populate an array with pinters to each node in the list. Then, step over the array with two pointers: left and right. Use these pointers to splice the list together in the correct order. That is alternate left.next = right, right.next = left, and so on until the two pointers cross.
# ***** PSEUDO-CODE *****
# current = head
# nodes = []
# while current:
#     nodes.append(current)
#     current = current.next
# left = 1
# right = len(nodes) - 1
# current = head
# while left <= right: # May need to handle this case differently to make sure the last node get's added correctly. <= maybe?
#      current.next = nodes[right]
#      right -= 1
#      current = current.next
#      current.next = nodes[left]
#      left += 1
#      current = current.next  