class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numsSet = set(nums)
        maxLength = 0

        for num in nums:
            if (num - 1) not in numsSet:
                current = num
                currentLength = 0

                while current in numsSet:
                    currentLength += 1
                    current = current + 1
                
                if currentLength > maxLength:
                    maxLength = currentLength
                    
        return maxLength

# IDEAS
# > The fastest we could sort the array is O(NlogN) and since we are required to get a runtime of O(N), we cannot sort the array.
# > The BFSol would be to loop over the array and for each element, check to see if the value one larger than it is in the array. Do this repeatedly for every element in the array and each time, when there are no mare values to add to the chain, store the length of the current longest sequence in a maxLength variable. After we finish, we return the maxLength variable.
# >> This solution would be very slow. If my reasoning is correct, for each element O(N), we would be looping over the entire thing O(N * N) = O(N^2). But since we may have to loop over every element recursively, the time complexity should be around O(N^N)... Not sure if this is correct, but if it is, it is not good.
# > Another idea:
# >> Loop over the array and put each value into a HashMap.
# >> While looping, also check to see if current - 1 is already in  the HashMap. If it is, we've found the next element in that sequence. We then add an entry to the HashMap where the key is our current element and the value is the value from Map[current - 1] with current concatenated onto the end (note that the HashMap will contain arrays, so we aren't really concatenating anything). By the time we reach the end of the array in one pass, we will have built up the longest _consecutive_ sequence in the array. However, we will not have yet joined any values/sequences that might be able to be concatenated. So this isn't an entirely complete solution...
# >> A possible fix would be to check the value above and the value below the current value. For example, if the current value is 4, we would check to see if 3 (current - 1) is in the HashMap and if 5 (current + 1) is in the HashMap. If we find them, we would concatenate their valeus onto the value stored in 4 appropriately.
# >>> For example: If we have [8, 4, 9, 1, 3, 2],
# >>>> We would add 8 : [8] on round 1, yielding { 8 : [8] }
# >>>> Then 4 : [4], yielding { 8 : [8], 4 : [4] } (3 and 5 not in HashMap, so do nothing extra)
# >>>> Then 9 : [9], yielding { 8 : [8], 4 : [4], 9 : [8, 9] } (8 in HashMap, so we append 8 to the front of entry 9)
# >>>> Then 1 : [1], yielding { 8 : [8], 4 : [4], 9 : [8, 9], 1 : [1] } (0 and 2 not in HashMap, so do nothing extra)
# >>>> Then 3 : [3], yielding { 8 : [8], 4 : [4], 9 : [8, 9], 1 : [1], 3 : [3, 4] } (4 in HashMap, so we append it to the entry for 3)
# >>>> Then 2 : [2], yielding { 8 : [8], 4 : [4], 9 : [8, 9], 1 : [1], 3 : [3, 4], 2 : [1, 2, 2, 4] } (since 1 and 3 are in the HashMap, we append the entries for both to the entry for 2)
# >>>>> Note: It doesn't matter what order we insert values into the successive lists for current - 1 and current + 1 b/c we only care about the number of elements in those lists, not the order of them. If we had to keep them in order (say to return the conssecutive list), we would need to append the current - 1 values to the front of the current List entry and append the current + 1 values to the end of the current List entry. We can use list.insert() to add elements to the beginning of the list, but this will take O(N) time, so it would be better to use some other data structure to do this.
# >>>> We've reached the end of the list. From here, we just loop over the HashMap to find the key:value pair with the longest list as it's value. The lenght of that list is the answer that we return. In this example, we return 4 - the length of the entry for 2.
# >>>> This solution runs in O(N) time - O(N) to build the HashMap and O(N) to find the largest value entry in the completed HashMap = O(2N) => O(N)
# OULTINE (PSEUDO CODE)
# Initialize a HashMap (no need for a fancy one)
# Loop: For each element (num) in nums,
#     If num in HashMap, continue (do nothing)
#     Add num : [num] to HashMap
#     If num - 1 in HashMap, add the values from HashMap[num - 1] to HashMap[num]
#     If num + 1 in HashMap, add the values from HashMap[num + 1] to HashMap[num]
# Instantiate maxLength variable
# Loop: For each value (sequence) in HashMap,
#     If sequence.length > maxLength, update maxLength
# Return maxLength
# ** The above solution didn't work **
# Another Idea:
# > If we add all values to a HashMap O(N), then loop over that HashMap and for... Nevermind. That won't work in O(N) time.
# >> Actually, it looks like this was the start of the NeetCode solution.
# NeetCode Solution
# > Add all elements to a Set.
# > Then, loop over the elements in the list and check if the value the preceeds the current value numerically is in the Set. If it is, that means that the current element is not the beginning of a consecutive sequence in the list of nums. So we continue. If the preceeding value is NOT in the set, then we know that we've found a value that begins a sequence of consecutive numbers in the set.
# >> Ex. If currentElement = 2, check to see if 1 is in the Set.
# > When we find a value that begins a sequence, we then loop to find how many following values are in the set. That is, we check to see if the number that would come after currentElement is in the set and so on until we fail to find another consecutive value. While we do this, we keep track of how many elements we encounter and once we find the end of the sequence, we check to see if our count is greater than a maxLength variable.
# > Once we've checked every value in the list, we return maxLength.
# > Time complexity: O(N)
# >> O(N) to add list to set
# >> O(N) to loop over the values again and check for sequences
# >> By looping over each sequence, we DON'T create an O(N^2) alg b/c we don't loop over the entire thing for each element in the list. Instead, we are only looping over each subsequence. At most, we have to visit each element in the list twice, since each value will only be a member of one sequence. That is, if there is one sequence, we will have to visit each element once during our sequence check and once to check if they are the beginning of a sequence. If there are two sequences, the same is true since an element from sequence 1 will only be visited while looping over sequence 1. And so on.
# > Memory Complexity: O(N)
# > We have to store the input array O(N) and a copy of it in the form of a Set O(N) => O(2N) => O(N)
# OUTLINE (PSEUDO CODE)
# Instantiate a set and add the elements from nums to it
# Instantiate maxLength = 0
# Loop: For each element num in nums,
#    If num - 1 is NOT in Set,
#        Instantiate currentLength = 0
#        Loop: while (num + 1) is in Set,
#            currentLength += 1
#        If currentLength > maxLength,
#            maxLength = currentLength
# Return maxLength