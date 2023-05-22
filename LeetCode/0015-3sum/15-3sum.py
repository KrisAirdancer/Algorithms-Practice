class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        triplets = []
        nums.sort() # O(NlogN) operation.

        for i in range(len(nums)): # Iterate over nums.
            if i != 0 and nums[i] == nums[i - 1]:
                continue
            
            left = i + 1
            right = len(nums) - 1

            # Use two pointers to find two values in the right partition that sum with nums[i] to yield 0.
            while left < right: # Stop when left and right are equal to prevent the final value from being used twice.
                sum = nums[left] + nums[i] + nums[right]

                if sum < 0:
                    left += 1
                elif sum > 0:
                    right -= 1
                else: # sum == 0, this is a valid triplet.
                    triplets.append([nums[i], nums[left], nums[right]])
                    left += 1 # To avoid duplicate values for the first position of the triplet, we will need to increment the left poitner by at least one.
                    # We need to skip duplicate values for the first position of the triplet, but also need to keep searching from where we are at to ensure that we don't miss any triplets. So, we step the left pointer forward until it is on a new value.
                    while nums[left] == nums[left - 1] and left < right:
                        left += 1
        
        return triplets

# NOTE: This problem looks like it is okay to return duplicate values in triplets because it is only the indicies that need to be different. However, it specifies that you cannot return duplicate triplets. This means that you CAN reuse the same value at the same index across triplets, but you CANNOT return triplets that contain either 1) the same three indices or 2) the same values (even if they were from different indices).
    # Ex. For sorted input [0, 0, 0, 0], you could conceivably return [[0, 0, 0], [0, 0, 0]] b/c you can use the zeros at indices 0, 1, and 3 and then the zeros at indices 0, 1, and 2. But because the triplets end up having the same values in the same positions, this is an invalid solution.
    # But an output of [[-1, 0, 1], [-1, 1, 0]] should, in theory, be acceptable.

# ***** NEETCODE SOLUTION *****
# > Select the first value by simply iterating over the input list.
#   > Need to prevent the reuse of duplicate values in each position by 1) sorting the array then 2) skipping values for the first position whenever we've already visited them (if current == last: continue).
# > Select subsequent values using a two pointer solution:
#   > Use two pointers at either end of the right partition.
#   > left++ if currentSum < 0
#   > right-- if currentSum > 0
#   > When a valid triplet is found, we need to add it to the output list AND step our left pointer forward until it is on a new value. We then need to continue searching from where the right pointer is. This ensures that we don't end up with any duplicate triplets.





