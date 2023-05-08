class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        countsDict = dict()

        for num in nums: # Count the number of occurances of the elements in `nums`
            if num not in countsDict:
                countsDict[num] = 1
            else:
                countsDict[num] = countsDict[num] + 1

        # Need to add one to the length b/c the first index, 0, won't get mapped to, but the largest possible index will be out of bounds
        counts = [[] for i in range(0, len(nums) + 1)] # List Comprehension to generate a List of empty Lists (the parent List is the length of nums plus one b/c we cannot use the 0 index - no elements will have a count of zero)

        for count in countsDict.items():
            counts[count[1]].append(count[0]) # Add the number from `nums` to the index that corresponds to its frequency (count)

        topKElements = [] # Our return list

        i = len(counts) - 1 # `i` keeps track of our position in the counts List, while `k` keeps track of the number of elements we've added
        while k > 0: # Loop until we've added k elements to the return list (as tracked by `k`)
            currentGroup = counts[i] # currentGroup is the current sublist in the counts List of Lists
            
            if currentGroup: # If the current sublist isn't empty (empty lists resolve to False when used in boolean contexts)
                for num in currentGroup: # Loop over all elements in the current sublist
                    if k <= 0: # If k elements are added while in this sublist loop, stop adding elements
                        break
                    else: # Add the current element to the sublist and decrement `k`
                        topKElements.append(num)
                        k -= 1
            
            i -= 1
        
        return topKElements

# (1) Write down what the problem is asking you to do (what questions do you have about the problem)
# (2) Understand your inputs (what questions do you have about your inputs)
# (3) Understand your output (what questions do you have about your outputs)
# (4) State the Brute Force Solution (BFSol)
# (5) State the algorithmic complexities (Time & Memory) for the BFSol
# (6) State the Best Conceivable Runtime (BCR)
# (7) What TYPE of algorithm best describes your goal?
# (8) List all possible algorithms of the selected type
# (9) Select an algorithm from the list in (8) to use for your solution
# (10) Outline your solution using your selected algorithm (don't pseudo code it - describe the idea in English)
# - Loop over the input array and count the number of occurances of each value using a HashMap (store the [value, count] pairs in the HashMap).
# - Then, make an array of length N, where N is the length of the input array.
# - Then, loop over the HashMap and add each value (key) to the array from the previous step at the index that corresponds to the count of that value. If more than one element have the same count, add them both to that position in the List using a List (a List inside a List).
# - Then, loop over the List from back to front (largest index to smallest index) and pull the first k elements encountered. If a given index has more than one element, loop over the elements in that sublist while still decrementing k - it doesn't matter from which end of the sublist you start, so just loop from lowest index to highest index.
# (11) State the algorithmic complexities (Time & Memory) for your solution
# (12) Optimize your solution
# (13) Outline (pseudo-code) your solution
# Instantiate a Dictionary `countsDict`
# Loop over the input array and store the counts in countsDict
# Instantiate a List of Lists (all empty to start) `counts`
# Loop over countsDict.items()
#     counts[currentElement.value].append(currentElement.key) // Place the current element in the index in the List that corresponds to the count of that element
# Instantiate return list `topKElements`
# int i = len(counts) - 1
# Loop over `counts` k times - while k > 0
#     For each element in current sublist
#         If k == 0, break
#         Add current element to topKElements
#         k--
#         i--
# return topKElements
# (14) Test solution with a few examples
# (15) Implement it (in actual code)