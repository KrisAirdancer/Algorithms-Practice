class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:


# LeetCode 15: 3Sum
# Timing:
# > March 31, 2023: 36 min
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
# IDEAS
# > Some Notes:
# >> Two Sum places each value in the array into a HashMap and sets the value equal to the the index that that value is at.
# >> Two Sum II uses two pointers to loop over the sorted array (it is pre-sorted) one from the front and one from the back. You essentially use Binary Search here to move the pointers towards their target values.
# > Thinking...
# >> It might be posible to loop over the input array and store intermediate sums and/or final sums in a HashMap along with the pair/tuple that generated that sum. I'm just not sure how to do this in a way that isn't Quadratic or worse.