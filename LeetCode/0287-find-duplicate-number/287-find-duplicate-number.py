class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow = 0
        fast = 0
        
        while True:
            slow = nums[slow]
            fast = nums[fast]
            fast = nums[fast]

            if fast == slow:
                break
        
        slow2 = 0
        while True:
            slow = nums[slow]
            slow2 = nums[slow2]

            if slow2 == slow:
                break
        
        return slow

# ***** IDEAS *****
# NEETCODE:
# > We are guaranteed that the item at index 0 is not part of a cycle. This b/c the problem specifies inputs of 1 to n, and zero does not fall in that range.
# We can use Floyd's algorithm to find the beginning of a cycle in a linked list.
#   > Floyd's alg is an alg for finding the beginning of a cycle in a linked list.
#   > Floyd's alg takes advantage of the observation that the distance between the beginning of a linked list and the beginning of a cycle is the same as the distance between the beginning of the cycle and the intersection point of a fast and slow pointer (see a diagram).
#   > Stepwise:
#     > 1) Start a fast and slow pointer at the beginning of the linked list.
#     > 2) Run the pointers until they intersect (are at the same node).
#     > 3) Leave the fast pointer where it is and start a new slow pointer at the beginning of the linked list.
#     > 4) Step the two slow pointers forward at the same rate until they are on the same node (they intersect).
#     > 5) This is the beginning of the cycle in the linked list.
# ***** OUTLINE *****
# > Instantiate a fast and slow pointer on the array: index = 0
# > Loop until fast == slow
#   > slow = nums[slow]
#   > fast = nums[fast]
# > Instantiate a new slow pointer over the input array
# > Loop until slow1 == slow2
# > Return the value at slow1 or slow2 (either will work)
# ***** PSEUDO-CODE *****
# slow = 0
# fast = 0
# 
# while fast != slow:
#     slow = nums[slow]
#     fast = nums[fast]
#     fast = nums[fast]
# 
# slow2 = 0
# while slow2 != slow:
#     slow = nums[slow]
#     slow2 = nums[slow2]
# 
# return slow