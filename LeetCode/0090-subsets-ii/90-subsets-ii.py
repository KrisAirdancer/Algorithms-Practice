class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        powerSet = []
        subset = []
        nums.sort()

        test = {}
        test["hello"] = [1, 2, 3]

        def DFS(i):
            if i == len(nums):
                powerSet.append(subset.copy())
                return
            subset.append(nums[i])
            current = nums[i]
            DFS(i + 1)
            current = subset.pop()
            while i < len(nums) and nums[i] == current:
                if i == len(nums):
                    return
                i += 1
            DFS(i)
        
        DFS(0)
        return powerSet



# ***** IDEAS *****
# IDEA 1:
# > This should be exactly the same, or very close to the same, algorithm as the one used in 78: Subsets.
# > We want to iterate over the input list and use a recursive backtracking alg to generate all possible subsets.
#   > Each recursive call will either 1) add the next value in the list or 2) not add the next value in the list.
# > Now, the question is, how do we handle duplicates? That is, prevent the addition of duplicate subsets.
#   > A very simple way to handle this would be to add all of the subsets to a Set(). But I feel like this can be done by just setting the decision tree up correctly instead.
#   > This will probably be handled with the base cases.
#     > Base Case: When i == nums.length, return
# 
# ***** OUTLINE *****
# 
# DFS()
#   Base Case: i >= nums.length:
#     Add current subset to powerSet list (subset.copy())
#     return
#   Add next element to the the current subset
#   Make recursive call (i + 1) < Step to the next element in the nums list
#   Remove most recently added item from current subset
#   Make recursive call (i + 1) < Step to the next element in the nums list
# Call DFS(0)