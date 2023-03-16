class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [1] * len(nums)
        postfix = [1] * len(nums)

        for i in range(1, len(nums)):
            prefix[i] = prefix[i - 1] * nums[i - 1]
        
        for i in range(len(nums) - 2, -1, -1): # Loop (i) from second to last element to first element
            postfix[i] = postfix[i + 1] * nums[i + 1]
        
        products = [0] * len(nums)

        products[0] = postfix[0]
        products[-1] = prefix[-1]

        for i in range(1, len(nums) - 1, 1):
            products[i] = prefix[i] * postfix[i]

        return products

# OUTLINE
# - Loop over the entire input array nums from left to right and keep a second array with the running product at each position - this is your prefix
# - Loop over the entire input array nums from right to left and keep a second array with the running product at each position - this is your postfix
# - Now, for the output array, the value at each index will be the product of the values at prefix[i - 1] and prefix[i + 1]
# PSEUDO-CODE
# Instantiate int array `prefix`
# Instantiate int array `postfix`
# Loop over `nums` to populate prefix (for 0 to length - 1)
# Loop over `nums` to populate postfix (for length - 1 to 0)
# output[0] = postfix[1] // The first element in the output has no prefix
# Loop to populate the output array (skip the first and last elements as they were handled above as special cases)
#     output[i] = prefix[i - 1] * prefix [i + 1]
# output[len(nums) - 1] = prefix[len(nums) - 2] // The last element in the output has no postfix
# Return `output`