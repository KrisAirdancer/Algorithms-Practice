class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        seenNums = set()

        for num in nums:
            if num in seenNums:
                return True
            else:
                seenNums.add(num)
        return False

# (1) Write down what the problem is asking you to do.
# - We need to check the given array for duplicates.
# - If duplicates found, return true; false otherwise.
# (2) Understand your inputs
# - A List of integers - integers can be negative
# - The List will always have at least one element in it
# (3) Understand your output
# - True if duplicates found in List; False otherwise.
# (4) State the Brute Force Solution (BFSo)
# - Loop over the array and for each element check all other values in the array to see if any are the same (a duplicate)
# (5) State the algorithmic complexities (Time & Memory) for the BFSo
# - Time: O(N^2) - For each element, loop over all other elements N * N = N^2
# - Memory: O(N) - Only need to store the given input array (List)
# (6) State the Best Conceivable Runtime (BCR)
# - BCR should be O(N) - we will have to visit each element in the list at least once. So our minimum runtime is O(N).
# (7) What TYPE of algorithm best describes your goal?
# - Searching
# (8) List all possible algorithms of the selected type
# - Binary Search
# - DFS - only for graphs
# - BFS - only for graphs
# - Dijikstra's - only for graphs
# (9) Select an algorithm from the list in (8) to use for your solution
# - None - going to have to use a custom alg b/c we are looking for more than one item.
#     - Algthough an interesting solution would be to sort the array O(NlogN) (quicksort), then use binary search to search for a duplicate of each element in the list.
# (10) Outline your solution using your selected algorithm (don't pseudo code it - describe the idea in English)
# - Loop over the List and for each element add it to a Set(). If the Set already contains that element, return True; if we reach the end of the List and haven't returned, all elements must be unique, return False.
# (11) State the algorithmic complexities (Time & Memory) for your solution
# - Time: O(N) - Only have to loop over the List once (length N) and adding/searching a set is O(1)
# - Memory: O(N) - Only need to store at most the input List (length N) and the Set (max length N)
# (12) Optimize your solution
# - No optimization possible - BCR achived.
# (13) Outline (pseudo-code) your solution
# - Initialize an empty Set()
# - Loop over length of array (for-each loop)
#     - If element is in Set(), return True
#     - Else, add element to Set()
# - Return False
# (14) Test solution with a few examples
# (15) Implement it (in actual code)