# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev = None # Create a temporary new head
        current = head # Create a pointer to keep track of our current location in the linked lists

        # Loop over the input list
        while current:
            temp = current.next # Store a reference to the next node (so we don't loose it)
            current.next = prev # Point the current node back to the node before it
            prev = current      # Move the pointer to the previous node forward to the newly attached node
            current = temp      # Move the pointer to the current node forward to the next node in the linked list
        
        return prev # At this point, prev points to the head of the reversed list (the tail of the input list)

# ***** INPUTS *****
# > A pointer to the head of a singly linked list.
# ***** OUTPUTS *****
# > A pointer to the head of a singly linked list.
# >> Specifically to the head of the reversed version of the input list.
# ***** QUESTIONS *****
# > Are we to make a copy of the input list or return a new linked list?
# ***** IDEAS *****
# Idea 1:
# > If we could traverse the list backwards, it would be easy to reverse it. We'd just make a temporary head and start tacking each item (starting with the end of the list) onto the temporary head. Once we'd attached all of the elements to the list, we return temp.next.
# >> However, this is not an option b/c the list is singly linked from head to tail, so we can't traverse it in reverse.
# Idea 2:
# > We're going to have to travrse the list from begining to end and add each element to the back of each other.
# > Let's keep things simple to start. Instead of reversing the given list, let's make a copy of it.
# > Initially, we can make a tail pointer "tail" and set tail = head. We will also create a "current" pointer to keep track of the node we are currently on in the reversed list. This is our setup. From here, we can begin looping. 
# Idea 3:
# > Setup
# >> RC = head
# >> tail = head
# >> OC = head.next
# >> temp = head.next.next
# >> head.next = Null
# > Loop
# >> OC.next = RC
# >> RC = OC
# >> OC = temp
# >> temp = OC.next
# > Return RC