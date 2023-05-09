class Solution:
    def generateParenthesis(self, n: int) -> List[str]:

        return self.generateParentheses(0, 0, n, [], [])

    def generateParentheses(self, openCount: int, closedCount: int, n: int, current: List[str], results: List[str]) -> List[str]:

        # Base Case: All open and closed parentheses have been added.
        if openCount == n and closedCount == n:
            results.append("".join(current)) # Add the current set of parentheses to the list of results
            # No need to return in the base case b/c a complete result will not trigger the below checks. Thus, we will "fall through" to the return at the bottom of the function.
        
        # Check if we are able to add an open parentheses.
        if openCount < n:
            current.append("(") # Add an open parentheses
            self.generateParentheses(openCount + 1, closedCount, n, current, results) # Make recursive call to continue building the solution. We must increment openCount by one because we added an open parentheses.
            current.pop() # "Backtrack" the current solution to return it to the current state.
        
        # Check if we are able to add a closed parentheses.
        if closedCount < openCount:
            current.append(")") # Add a closed parentheses.
            self.generateParentheses(openCount, closedCount + 1, n, current, results) # Make a recursive call to continue building the current solution. We must increment closedCount by 1 b/c we added a closed parentheses.
            current.pop() # "Backtrack" the current solution to return it to the current state.

        return results # Return the list of results.

# ***** INPUTS *****
# > A single integer representing the number of pairs of parentheses to be generated.
# >> Ex. 2 indicates two pairs of parentheses. Two open "(" and two closed ")".
# ***** OUTPUTES *****
# > A list of strings where each string is a valid set of parentheses.
# ***** OUTLINE *****
# NeetCode
# > Use backtracking to generate all combinations of valid parentheses.
# > We are able to add n open parentheses and n closed parentheses.
# >> We can only add an open parentheses when the number of open parentheses added is less than n.
# >> We can only add closing parentheses when the number of closed parentheses is less than the number of open parentheses.
# >> We return (base case) when the number of open parentheses equals n AND the number of closed parentheses equals n.