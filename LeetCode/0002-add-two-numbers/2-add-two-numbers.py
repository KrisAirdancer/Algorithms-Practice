# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        rHead = ListNode()
        
        carry = 0
        current = rHead
        while l1 and l2:
            sum = l1.val + l2.val + carry
            newNode = ListNode(int(sum % 10))
            current.next = newNode
            current = current.next
            carry = int(sum / 10)

            l1 = l1.next
            l2 = l2.next

        while l1:
            sum = l1.val + carry
            newNode = ListNode(int(sum % 10))
            current.next = newNode
            current = current.next
            carry = int(sum / 10)

            l1 = l1.next
        while l2:
            sum = l2.val + carry
            newNode = ListNode(int(sum % 10))
            current.next = newNode
            current = current.next
            carry = int(sum / 10)

            l2 = l2.next
        
        if carry != 0:
            current.next = ListNode(carry)
        
        return rHead.next

# ***** IDEAS *****
# IDEA 1:
# > Loop over the two input lists simultaneously. For each node, add the values together and extract the second (Least Significant Digit) digit and store it in the next node in the return list, then store the Most Significant Digit in a variable as the carray. Continue until the input lists are expended.
# > The trick will be handling input lists of differing length.
#   > we need to loop over the longer list and simply transfer the values to the output list.
#   > Wait, this isn't an issue. Since the numbers are reversed, the heads of the linked list will represent the Least Significant Digit. This means that we can just start adding the numbers together until one of the lists is null. At which point we simply add the remainder of the list that still has nodes to the output list.
# ***** OUTLINE *****
# Instantiate output list (dummy node head: rHead)
# Instantiate carry = 0
# While both lists are not null,
#     sum = l1.val + 12.val + carry
#     Add a new node with .val = sum mod 10 (to extract LSD)
#     carry = sum / 10 (to extract MSD)
# If l2 not None, rHead.next = l2
# If l1 not None, rHead.next = l1
# Return dummy.next