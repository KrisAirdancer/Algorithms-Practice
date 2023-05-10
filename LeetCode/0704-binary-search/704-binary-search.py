class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + ((right - left) // 2) # The // does integer division instead of floating piont division.
            if nums[mid] == target:
                return mid
            elif target < nums[mid]:
                right = mid - 1
            else: # target > nums[mid]
                left = mid + 1

        return -1

# ***** INPUTS *****
# > A sorted array of integers to be searched.
# >> This must be the case or we cannot perform Binary Search.
# >> At least, if it is not 
# > An integer to be found in the given array.
# ***** OUTPUTS *****
# > The index of target in the given array.
# ***** IDEAS *****
# > Since we have to search in O(logN) time, we will need to use Binary Search (surprise, surprise).
# ***** OUTLINE *****
# > Binary Search works by checking the target against the value at the midpoint. If the midpoint is not the target value, we split the array in half and repeat. We continue this process (check midpoint then split) until the target is found or until the list contains only one item that is not the target (return -1 in this case).
# > We can do this recursively or iteratively.
# ***** PSEUDO-CODE *****
# Instantiate left = 0 and right = nums.length - 1
# Loop: While left < right, # Or should this be left <= right?
#     Calculate midpoint (mid) -- mid = low + ((high - low) / 2)
#     If nums[mid] == target,
#         Return mid
#     Else if target > nums[mid],
#         left = mid
#     Else if  target < nums[mid],
#         right = mid
# Return -1