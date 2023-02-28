# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode()
        currentNode = head
        while list1 and list2:
            if list1.val < list2.val: # Insert list1
                currentNode.next = list1
                currentNode = currentNode.next
                list1 = list1.next
            else: # Insert iist 2
                currentNode.next = list2
                currentNode = currentNode.next
                list2 = list2.next
        if list1:
            currentNode.next = list1
            currentNode = currentNode.next
            list1 = list1.next
        if list2:
            currentNode.next = list2
            currentNode = currentNode.next
            list2 = list2.next
        return head.next