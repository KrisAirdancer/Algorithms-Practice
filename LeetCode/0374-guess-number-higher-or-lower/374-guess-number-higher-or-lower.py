# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        return int(Solution.recursiveGuessNumber(1, n))

    def recursiveGuessNumber(left: int, right: int) -> int:
        mid = left + ((right - left) / 2)

        hint = guess(mid)

        if hint == 0:
            return mid
        elif hint < 0:
            return Solution.recursiveGuessNumber(left, mid - 1)
        elif hint > 0:
            return Solution.recursiveGuessNumber(mid + 1, right)

# (1) Write down what the problem is asking you to do.
# - No need to go through these steps in detail. This is a binary search problem. It is literally writing a binary search.
# (2) Understand your inputs
# - Some integer n that represents the largest possible value in the range
# - n defines our range: 1 to n
# - Our range is all values from 1 to n
# (3) Understand your output
# - We must return the target value.
# - The target value is not explicitly defined, but instead implicitly defined via the guess() API
# (4) What type of algorithm best describes your goal?
# - Binary Search
# (5) List all possible algorithms of the selected type
# - Searching algs. But this is Binary Search.
# - DFS
# - BFS
# - Dijikstra's
# - Linear Search (the BFS)
# (6) State the Brute Force Solution (BFS)
# - Linear search to find the element. That is, loop from 1 to n until we find the target.
# (7) State the algorithmic complexities (Time & Memory) for the BFS
# - Time: O(N) - Have to loop over the entire thing (potentially) - not to bad really
# - Memory: O(1) - Don't even need to store an array b/c we know the values implicitly
# (8) State the Best Conceivable Runtime (BCR)
# - BCR for this problem is O(logN) b/c we can concievably do it using Binary Search.
# (8.1) Select an algorithm from (5) to use for this problem
# - Binary Search
# (9) Outline your solution using your selected algorithm
# *Recursive solution
# Initialize variables: left, right, guess (midpoint)
# Calculate midpoint (guess) with low + ((high - low) / 2)
# If guess(guess) == 0, return true
# If guess(guess) < 0, search left half of values
# If guess(guess) > 0, search right half of values
# (10) State the algorithmic complexities (Time & Memory) for your solution
# - N = n
# - Have to make logN guesses to get to the bottom (splitting the set of values in half each time means log(N) splits before we have a list of length 1)
# - Therefore, O(logN) Time complexity
# - This solution is recursive and will place log(N) calls on the stack.
# - Therefore, Memory complexity is O(logN)
# (11) Optimize your solution
# - No optimizations to see
# (12) Outline (pseudo-code) your solution
# - See (9)
# (13) Test solution with a few examples
# - 
# (14) Implement it (in actual code)