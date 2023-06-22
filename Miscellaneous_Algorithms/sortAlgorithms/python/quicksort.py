class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
        self.quicksort(nums, 0, len(nums) - 1)
        return nums

    def quicksort(self, nums, left, right):
        if left >= right: # Base Case: If left passes right, we've processed the entire partition.
            return

        firstLarger = left # THe leftmost value in the right (larger) partition.
        current = left # The element currently being evaluated.

        while current < right: # Sort the current partition.
            if nums[current] <= nums[right]: # If current element is less than or equal to the pivot element. Note: right is the location of the pivot.
                nums[current], nums[firstLarger] = nums[firstLarger], nums[current]
                firstLarger += 1
            current += 1
        
        # Swap the pivot from the rightmost end to the dividing line between the partitions.
        nums[firstLarger], nums[right] = nums[right], nums[firstLarger]

        self.quicksort(nums, left, firstLarger - 1) # Sort left half.
        self.quicksort(nums, firstLarger + 1, right) # Sort right half.

# PERFORMANCE
# Time Complexity: O(NlogN) best case, O(N^2) worst case
#   > If a bad pivot is chosen (a very small or the smallest element), we will only sort a single item each time we iterate over the array.
# Memory Complexity: O(N) or O(1) depending on how you look at it.
#   > If we count the input array as memory, O(N); if we don't, O(1) b/c no extra space is needed beyond the original input array.

# OUTLINE - Quicksort
# Select a pivot as rightmost element
# Instantiate pointers: firstLarger and current
# Loop over all elements with current
#   If current is smaller than pivot,
#     Swap current with firstLarger
#     Step firstLarger forward
#   Step current forward
# Swap pivot with firstLarger
# return: Sort left half
# return: Sort right half