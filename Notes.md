class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:


# LeetCode 15: 3Sum
# Timing:
# > March 31, 2023: 36 min
# > April 1, 2023: 56 min
# OUTLINE
# Inputs
# > An array of integers of at least length 3
# > The integers can be negative, positive, or zero
# Outputs
# > Need to return an array of arrays where each sub-array contains integers that sum to zero.
# > There is no `target`, the "target" is zero (0)
# > There can be multiple unique solutions.
# >> It is possible for there to be no solution. Ex. nums = [0, 1, 1] does not have a triplet that sums to 0
# > [1, 2, 3] == [2, 1, 3], etc. That is, the order of the integers in the triplets does not matter.
# > The order of the triplets (sub-arrays) in the parent array does not matter.
# Brute Force Solution (BFSol)
# > Calcualte all possible three value sums and store them in a HashMap along with the triplet that sums to that value.
# >> Could make this better by storing the sum as the key and an array of triplets as a value. We then just have to return the value that is mapped to "0"
# >> Loop over nums, for each value, loop over all other possible values twice, the first time to find the second operand and the second time to find the third operand.
# >> This solution would be O(N^3) time complexity. Not good.
# Best Conceivable Runtime (BCR)
# > The BCR for this problem is O(N). Since we are trying to find some combintation of values in the input array, it is conceivable that we will only need to visit each value in the input array once. Thus, O(N).
# *** IDEAS ***
# > Some Notes:
# >> Two Sum places each value in the array into a HashMap and sets the value equal to the the index that that value is at.
# >> Two Sum II uses two pointers to loop over the sorted array (it is pre-sorted) one from the front and one from the back. You essentially use Binary Search here to move the pointers towards their target values.
# > Thinking...
# >> It might be posible to loop over the input array and store intermediate sums and/or final sums in a HashMap along with the pair/tuple that generated that sum. I'm just not sure how to do this in a way that isn't Quadratic or worse.
# *** NeetCode Solution ***
# > Sort the input array `nums`, then loop over all of the values in `nums`. For each value, perform Two Sum II to find the second and third values such that either 1) they sum to the inverse of the first value (Ex. If first value is -3, find two values that sum to 3); or 2) all three values sum to zero (Ex. If first is -3, and left pointer = -3 and right = 4, sum = -2 (less than target of 0) so increment left to get left = 1 where sum = 2 (greater than target of 0), so decrement right to get right = 2, now first = -3 left = 1 and right = 2 => -3 + 1 + 2 = 0).
# >> Go with option 2
# > Because the input array `nums` can contain duplicates, but our output cannot contain duplicate solutions (permutations of solutions count as duplicates), we have to handle this somehow.
# >> One way to handle this is to check each time we increment one of the pointers: if left is incremented, for example, we would check if left == right and left == first, if either check returns true, we increment left one more time.
# >>> Note: We won't have to do the left == right check b/c that will be our loop criteria. When the left and right pointers are equal, we break out of the loop. So we will never have to worry... Wait, yes we might have to deal with this... If we are repeatedly incrementing left until it no longer equals first and right is the next value after the one left and first are on, we would ...
# >>> We can do two things: 1) surround the if first + left + right == 0 check with an if statement that checks if left == right and left == first and first == right. If any of them are equal, we don't check if they are equal to zero. And 2) use while loops to move the left and right pointers instead of if checks: If left == first, left++ (same for right but -- instead). We then have the entire thing surrounded in a while loop with the condition, while left != right. All of this should prevent the algorithm from returning duplicates and cause it to stop when the left and right cross.
# PSEUDO CODE 1
# Sort the input array nums
# Instantiate a list of lists to store the output arrays
# Loop: For num in nums,
#     Instantiate left and right pointers
#     Instantiate `sum` to nums[left] + nums[right] + num
#     Loop: While left != right (stop when they are equal - technically they don't have to be at the same index, they can be at the same value - stop them at the same index anyway):
#         Loop: While sum < 0,
#             left++
#             sum = nums[left] + nums[right] + num
#         Loop: While sum > 0,
#             right--
#             sum = nums[left] + nums[right] + num
#         If left != right AND left != first AND right != first,
#             Add []num, left, and right] to output array as a sub-array
# Return output array
# Time Complexity: O(N) - Looping over `nums` is O(N), => O(N^2) - sorting also takes O(NlogN)
# Memory Complexity: O(N) - Since we only need to store the input array and a second smaller array (at most length N - contains all of the values in `nums`), we have O(N)
# > Make sure to pay attention to the memory complexity of your sorting alg.