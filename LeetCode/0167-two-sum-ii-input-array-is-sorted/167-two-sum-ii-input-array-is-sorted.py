class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        left = 0
        right = len(numbers) - 1
        sum = numbers[left] + numbers[right]

        while sum != target:
            if sum < target:
                left += 1
            if sum > target:
                right -= 1
            sum = numbers[left] + numbers[right]
        
        return [left + 1, right + 1]

# OUTLINE
# > Note: Input array is sorted in ascending order. Ex. [1, 2, 3, 4, ...]
# > Note: Output is to be 1-indexed. NOT zero indexed!
# IDEA:
# > Create two pointers with which to loop over the array: one starting at the beginning and the other at the end. Then loop over the array until the values at the two pointers sum to the target value. On each iteration of the loop, if currentSum is less than target, increment the left pointer by one; if currentSum is greater than the target, decrement the right pointer by one.
# PSEUDO CODE
# Instantiate left pointer and right pointer: left and right
# Instantiate `sum` to the sum of numbers[left] + numbers[right]
# Loop: While sum != target,
#     If sum < target,
#         left++
#     If sum > target,
#         right--
#     Update `sum` as left + right
# Instantiate array containing `left + 1` and `right + 1`
# Return array