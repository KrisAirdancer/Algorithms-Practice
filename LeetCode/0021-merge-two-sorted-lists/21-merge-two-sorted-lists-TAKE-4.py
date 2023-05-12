# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        rHead = ListNode()
        current = rHead

        while list1 and list2:
            if list1.val <= list2.val:
                current.next = list1
                list1 = list1.next
            else:
                current.next = list2
                list2 = list2.next
            current = current.next

        if list1:
            current.next = list1

        if list2:
            current.next = list2

        return rHead.next
        
# ***** INPUTS *****
# > The heads two two linked lists (sorted lists).
# ***** OUTPUTS *****
# > The head to a linked list that was created by merging the two input lists.
# ***** IDEAS *****
# > To start, we are going to need a linked list traversal alg.
# > On top of this, we are going to have to add logic to merge the two lists based on which node from which list needs to come next.
# Idea 1:
# > Traverse the two lists simultaneously.
# > On each iteration, compare the two current nodes from each of the two linked lists.
# > For whichever node is larger, add it to the return list.
# > No need to use a temporary head to start the return list. We can just use the smallest of the two heads as the return head.
# ***** OUTLINE/PSEUDO-CODE *****
# Instantiate rHead = None
# If list1.val <= list2.val,
#     rHead = list1
# Else,
#     rHead = list2
# While list1 and list2,
#     If list1 and list1.val <= list2.val,
#         rHead.next = list1
#         list1 = list1.next
#         rHead = rHead.next
#     Else if list2,
#         rHead.next = list1
#         list1 = list1.next
#         rHead = rHead.next
# TAKE TWO
# > Start by simply stepping over the two lists.
# While list1 or list2,
#     If list1,
#         list1 = list1.next
#     If list2,
#         list2 = list2.next
# > Now, modify the traversal code to merge the two linked lists WITHOUT handling sorting.
# If not list1,
#     Return list2
# If not list2,
#     Return list1
#
# rHead = None
# current = None
# If list1.val <= list2.val,
#     rHead = list1
#     list1 = list1.next
#     current = rHead
# Else,
#     rHead = list2
#     list2 = list2.next
#     current = rHead
#
# While list1 or list2,
#     If list1 and list2,
#         If list1.val <= list2.val,
#             current.next = list1
#             list1 = list1.next
#         Else,
#             current.next = list2
#             list2 = list2.next
#     Else if list1,
#         current.next = list1
#         list1 = list1.next
#     Else, # list2 not null
#         current.next = list2
#         list2 = list2.next
# Return rHead















