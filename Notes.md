class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        print("candidates: ", candidates, "target: ", target)
        combos = []
        currentCombo = []

        def DFS(i: int):
            print("\nAT: DFS()")
            currentSum = sum(currentCombo)
            print("i: ", i, ", currentCombo: ", currentCombo, ", currentSum: ", currentSum)
            if currentSum == target:
                print("Adding currentCombo: ", currentCombo)
                combos.append(currentCombo.copy())
                return

            if currentSum > target:
                print("currentSum too large: ", currentSum)
                return

            if i > len(candidates) - 1:
                print("i out of bounds: ", i)
                currentCombo.append(currentCombo[-1])
                DFS(i + 1)

                # currentCombo.pop()
                # DFS(i + 1)

                return
            else:
                print("i in bounds: ", i)
                currentCombo.append(candidates[i])
                DFS(i + 1)

                currentCombo.append(currentCombo[-1])
                DFS(i + 1)

                currentCombo.pop()
                currentCombo.pop()
                DFS(i + 1)
        
        DFS(0)
        print("returning combos: ", combos)
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
