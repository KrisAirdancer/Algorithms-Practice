class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        subsets = []
        subset = []
        candidates.sort() # We sort the array here to make it easier to skip duplicate elements later on. If they are all in one spot in the list, we can skip them easily.

        def DFS(i: int):
            if sum(subset) == target:
                subsets.append(subset.copy())
                return
            if i >= len(candidates): # The subsets can contain at most the same number of elements as are in the input list, but no more.
                return
            if sum(subset) > target: # We can stop early if the current sum exceeds the target value.
                return
            
            subset.append(candidates[i])
            DFS(i + 1) # Go down the route that adds the current element.
            current = subset.pop()
            while i < len(candidates) and candidates[i] == current: # Skip all duplicate elements.
                i += 1
            DFS(i) # Go down the route that does NOT add the current element. Note: This route also skips duplicate values (duplicates of the current value).

        DFS(0)
        return subsets

# ***** IDEAS *****
# IDEA 1:
# > Note: We will have to handle duplicate values in the input array.
#   > This means that we will likely have to 1) sort the input array - O(NlogN) - and 2) skip the duplicate elements when making recursive calls - O(N).
#   > This is because we cannot use the same value more than once in an output set.
#   > Oops! We can use duplicate values. Specifically, what it is saying is that we can use each item in the input array ONLY ONCE. Not that we have to scrub the duplicates out.
# > The overall strategy that we will have to employ here is to generate all of the unique subsets that are possible for the input and only add the ones whose values sum to the target value to the output list.
#   > We can do this using backtracking. We take two routes for each item in the list: 1) add the current element or 2) don't add the current element.
#   > From here, we just need to get the base cases right.
# > Base Cases:
#   > When the current subset's sum becomes larger than the target value, return.
#   > When the size of the list becomes larger than the input list, return.
#   > When the sum of the current subset == target, add subset to powerSet AND return.
# > NOTE: We can't just skip over duplicate values. If we do, we will fail to account for elements that appear twice in the input list.
#   > So, this is similar to generating the Power Set.
# > Wait, this is just generating the "Power Multiset" of the input list and then removing all of the elements that don't sum to the target value.
#   > That is, we aren't generating all permutations, we are generating the "Power Set," which doesn't contain duplicate sets.
#   > Thus, we can just implement a Power Set alg, then modify it to only add subsets that sum to the target value.
#   > We can cut off a route when the sum becomes larger than the target.
# > NOTE: We don't need to sort the input list b/c once a route reaches a sum of target, adding any value to it will cause it to go above target. Additionally, the constraints of the problem specify that the input list will contain values of 1 or greater. It won't contain zero or negative values.
# 
# ***** OUTLINE *****
# Instantiate a return list: subsets
# Instantiate a working list: subset
# DFS(i: int): # NOTE: I might have to pass in a copy of the current subset.
#   Calculate the sum of subset
#   If i >= len(candidates), return
#   If sum(subset) > target, return
#   If sum(subset) == target, add subset.copy() to subsets AND return
#   Add the candidates[i] to subset
#   Call DFS(i + 1)
#   Remove the most recently added element from subsets
#   Call DFS(i + 1)
# Call DFS(0)
# Return subsets