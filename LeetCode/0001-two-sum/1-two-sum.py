class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seenNums = dict()

        for i in range(len(nums)):
            print("--- ", i, " ---")
            diff = target - nums[i]
            print(diff)
            if diff in seenNums:
                print("diff in seenNums, ", seenNums[diff])
                return [seenNums[diff], i]
            else:
                print("else")
                seenNums[nums[i]] = i

# (1) Write down what the problem is asking you to do (what questions do you have about the problem)
# - We need to return the indicies of two integers in the given list that sum to the target.
# (2) Understand your inputs (what questions do you have about your inputs)
# - A List of integers which has at least two values in it and may contain negative values.
#     - The List of integers is guaranteed to contain exactly two values that sum to target
# - An integers that we must find two values that sum to it - our target value - target can be negative
# (3) Understand your output (what questions do you have about your outputs)
# - We simply return two integers that represent the indices of the two integers in the array that sum to the given target value
#     - Specifically, we are returning a List containing the indicies of the two values that sum to target
# (4) State the Brute Force Solution (BFSol)
# - Loop over the array: for each value in the array, loop over all other values and check if the two current values sum to target.
# (5) State the algorithmic complexities (Time & Memory) for the BFSol
# - O(N^2)
# (6) State the Best Conceivable Runtime (BCR)
# - O(N) - In the worst case senario, we are going to have to visit every element in the array.
# (7) What TYPE of algorithm best describes your goal?
# - Searching? Not really searching for a single value though. So traditional search algs won't work.
# (8) List all possible algorithms of the selected type
# - N/A
# (9) Select an algorithm from the list in (8) to use for your solution
# - N/A
# (10) Outline your solution using your selected algorithm (don't pseudo code it - describe the idea in English)
# Option 1: BFSol
# Option 2: Sort the input array and then use two pointers (left and right) to locate the two indicies.
#     - This would be O(NlogN) on average. Can we get this down to O(N)?
#     - Wait! This won't work! If we sort the array, we won't get the correct indices of the values relative to the input array.
# Option 3:
# - Use a Dictionary to keep track of the values we've seen as we traverse the List. On each iteration, we calculate target - current, then check to see if the result is a key in our Dictionary. If it is, we can return the index of current and the value stored in the Dictionary.
# (11) State the algorithmic complexities (Time & Memory) for your solution
# - Option 2:
#     - O(NlogN) - sorting takes O(NlogN) time and the two pointers will take O(N) time to traverse the array. So O(NlogN)
# - Option 3:
#     - O(N) - We only need to lop over the input List once b/c by the time we hit the second element for our sum, the first element will already be in the Dictionary and we will find it. Worst case is that the second element is the last element in the List. Dictionary access is O(1).
# (12) Optimize your solution
# - There should be an O(N) solution, but I haven't yet been able to come up with one.
# (13) Outline (pseudo-code) your solution
# Option 1:
# Sort the input array (ask interviewer if we should make a copy or sort the original (optimize for memory)) - I'll make a copy as it is better software practice
# Initialize two pointers: left and right
# Loop over sNums (while sum != target)
#     sum = arr[right] + arr[left]
#     if sum < target, left++
#     if sum > target, right--
# return left and right
# 
# Option 2:
# Initialize Dictionary seenValues
# Loop over input array (indexed for loop)
#     Calculate difference as target - nums[i]
#     If difference is in Dictionary, return [dictValue@nums[i], i]
#     Else, add [nums[i], i] to Dictionary
# (14) Test solution with a few examples
# (15) Implement it (in actual code)