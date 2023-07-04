class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        combos = []
        currentCombo = []

        def DFS(i: int):
            currentSum = sum(currentCombo)

            # Base Case: currentCombo sums to target
            if currentSum == target:
                combos.append(currentCombo.copy())
                return

            # Base Case: i is out of bounds or currentSum is too large
            if currentSum > target or i >= len(candidates):
                return
            
            currentCombo.append(candidates[i])
            # Recursive Case: Add the same item to the combo again.
            DFS(i)
            # Recursive Case: Stop adding the current item to the combo. Remove the current copy and step forward in the candidates list. The DFS(i) call above, will add the current element to the combo, then add it again AND leave it on there (add it again and remove the second copy), so that call is handling the case where we add the current item. The DFS(i + 1) call below handles the cases where we don't allow duplicates to be added from the point of the DSF(i + 1) call onward.
            currentCombo.pop() # Remove the current element b/c the DFS(i) call handles adding the duplicate value. This prevents it from being added twice in one round.
            DFS(i + 1)
        
        DFS(0) # The initial call to begin the recursion. We start at i = 0, the first element in the candidates array.

        return combos



# **** IDEAS *****
# IDEA 1: BFSol
# > Generate a list of all possible combinations of values in the input list that have a sum equal to the target.
# > That is generate a list of all possible combinations and then keep only the ones that sum to target.
# > The issue with this is that we need to know when to stop. How do we know that we don't have any valid combinations left?
# 
# IDEA 2: Backtracking
# > Use backtracking to generate all possible combinations that sum to target.
# > Base Case(s):
#   > If currentSum == target, add current operands to results.
#   > If currentSum < target, continue.
#   > If currentSum > target, return without adding operands to results.
#   > If i > len(nums) - 1, return
# > On each iteration/recursive call, we add the next value to the results list.
#   > This will work if we aren't working with duplicates. But we are allowed to use the same value more than once.
#     > To handle this, we can create a recursive route that repeatedly adds the most recently added value to the list.
#     > Same base cases, but we just add the same value over and over instead of the next value.
#     > Ex. OUTLINE
#       > Append next value in the list to currentOperands
#       > DFS(i + 1) # Recursive call to route with next operand from input list.
#       > Append currentOperands[-1] to currentOperands (add the most recently added operand to the current list of operands as a duplicate).
#       > DFS(i + 1) # Recursive call to the route with theduplicate operand.
#       > Remove most recently added TWO operands (we added it twice).
#       > DFS(i + 1) # Recursion to route without the most recently added operand.
# NEETCODE
# > Create a recursive tree (a decision tree) that each time it splits, it removes one element from the candidates list from the list of available values.
# > That is, if you go left, you can continue adding the current element; if you go right, you can no longer add the current element.
# > In this way, we ensure that the two routes never generate the same combinations of values.
# > This solution has a Time Complexity of O(2^t) where t is the target sum value.
#   > This is b/c each "iteration" generates two routes in the tree. Since our base case is when the currentSum >= target, the tree grows to a maximum depth of target.




