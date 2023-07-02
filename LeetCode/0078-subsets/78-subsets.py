class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        subsets = []
        currentSet = []
        
        def DFS(i: int):
            if i >= len(nums): # If the current index is not a valid element/index, add the current subset to the return list and terminate the recursion (return).
                subsets.append(currentSet.copy()) # Need .copy() b/c currentSet contains a reference to the list and if we append the reference, we'll continue to modify the list later on.
                return
            
            currentSet.append(nums[i]) # Add the next element to the list.
            DFS(i + 1) # Continue down the path where we add the current element.

            currentSet.pop() # Remove the current element (make it as if we didn't add the current element).
            DFS(i + 1) # Continue down the path where we didn't add the current element.

        DFS(0) # Start the recursion.
        return subsets

# ***** IDEAS *****
# IDEA 1:
# > Need to use backtracking to generate all of the subsets
# > Could start with the full list as a subset, then recurse down by removing one element at a time from the list.
#   > However, this won't generate all subsets. It will only generate subsets where the last item is removed on each iteration.
# > We can use a stack to keep track of the current subset. Thus, we can easily pop elements as we backtrack.
# NEETCODE
# > Use backtracking.
# > Use a nested function to perform DFS on the input list.
#   > Pass this function the index of the element in the array to add to the current subset.
# > Make two recursive calls: one without removing the most recently added element first and one after removing the most recently added element before the call.
# ***** OUTLINE *****
# Instantiate a return list: subsets
# Instantiate a list: currentSet
# Make a recursive call to DFS(0) to start the recursion.
# DFS(index: i):
#   If i is out of bounds of the array,
#     Add a copy of currentSet to subsets
#     Return
#   DFS(i + 1) # Recursive call to add the next element to the current subset
#   # Remove the first element (backtrack) from currentSet and then add the next item in the list.
#   Pop() top element from currentSet
#   DFS(i + 1)
# Return subsets