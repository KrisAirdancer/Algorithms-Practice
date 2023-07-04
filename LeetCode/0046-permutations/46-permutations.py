class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        permutations = []
        
        def DFS(nums, permutation):
            if not nums: # Base Case: If the list of available elements is empty, we have nothing more to add, indicating that the current permutation is complete.
                permutations.append(permutation)

            for i in range(len(nums)): # Loop over all available elements and generate a path in the decision tree for each one.
                numsSubset = nums[:i] + nums[i+1:] # Here, we create a new list of available elements by grabbing all of the items before the element at i (in [start:stop], stop is exclusive) and all of the elements after i, and creating a new list of those items. Ex. [1, 2, 3] for i = 1 becomes [1, 3].
                newPerm = permutation + [nums[i]] # Extract the current element from nums and append it to the current permutation. Note that all that is happening here is the addition of one list, permutation, to another list, a list with a single element that is the current element in nums (at index i).
                DFS(numsSubset, newPerm) # Generate a path in the decision tree for this permutation.

        DFS(nums, [])
        return permutations

# ***** IDEAS *****
# IDEA 1: 
# > This looks to be a version of a backtracking problem.
# > The only difference seems to be that order matters. As opposed to other backtracking problems where order doesn't matter.
#   > THat is, in other problems, [1, 2, 3] is considered the same as [2, 1, 3]. In this problem, [1, 2, 3] is distinct from [2, 1, 3].
# > So all we should need to do is adjust the boilerplate backtracking alg to include all permutations instead of excising them.
#   > We just have to be careful not to inadvertently include duplicates. Ex. [1, 2, 3] and [1, 2, 3].
# > In the boilerplate backtracking alg we conduct the following steps,
#   > Base case
#   > Add element
#   > Recursive call not stepping forward: DFS(i)
#   > Remove most recently added element
#   > Recursive call stepping forward: DFS(i + 1)
# > Thus, hypothetically, all we need to do is swap the first recursive call, DFS(i), for a DFS(i + 1) recursive call.
#   > This should cause the decision tree to generate permutations.
#   > It should also prevent any given value from being added to a permutation more than once. Ex. [1, 1, 1, ...]
# > Tested it on paper. This is not correct. This solution will only generate the Combinations, not Permutations.
# IDEA 2:
# > The set of permutations is the set of all possible combinations of elements in the list.
# > This means that we will need a decision tree that has a path for each possible permutation.
# > Thus, we will need to make a path from the root for each of the values in the input list, then a path from each of those nodes for each of the remaining elements, and so on.
#   > This is a factorial. That is, the number of permutations from a list of size N is N!.
#   > This means that each level will contain a number of nodes equal to the number of nodes in the previous level times the number of elements remaining in the list.
# > For this solution, we should be able to use a nested function that contains a loop that makes recursive calls to itself. The loop makes a recursive call for each of the possible routes from that point in execution.
# > We can have a global list of permutations to add each permutation to as the recursion reaches its base case.
# > One issue with this solution is that we will be generating duplicate permutations. Ex. [1, 0] and [1, 0]
#   > One solution would be to just keep all of the permutations in a Set, then we only get one of each.
#   > The issue with this solution is that we are not using an optimized decision tree. We will be generating more permutations than necessary.
#   > If we can design a better tree, we will be able to generate only the permutations that we need.
# > Oops. Not quite. This solution will work. I just drew the decision tree wrong.
#   > If on each iteration, we can select from only the remaining items, we end up with (N - 1) options on each iteration. Thus, the last split in the tree (the routes between second to last and last levels) only have one option. That is, there is only one item to pick from, so the last two levels of the tree have the same number of nodes.
# > Each iteration will have a different set of options to choose from.
#   > That is, instead of just passing an index down, we'll need to pass the list of available options to choose from.
#   > The question is how?
#   > On the first iteration, we can simply loop over the entire input list and on each iteration add each value to the permutation that gets passed to the recursive call.
#   > However, on all subsequent iterations, we want to be able to remove the item we just added from consideration.
#   > We could do this by removing it from the list that we pass to the recursive call, but this would take O(N) time. Not good.













