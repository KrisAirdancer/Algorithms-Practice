# LeetCode 128: Longest Consecutive Sequence
class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:

# Time Tracking:
# March 24, 2023: 23 min
# IDEAS
# > The fastest we could sort the array is O(NlogN) and since we are required to get a runtime of O(N), we cannot sort the array.
# > The BFSol would be to loop over the array and for each element, check to see if the value one larger than it is in the array. Do this repeatedly for every element in the array and each time, when there are no mare values to add to the chain, store the length of the current longest sequence in a maxLength variable. After we finish, we return the maxLength variable.
# >> This solution would be very slow. If my reasoning is correct, for each element O(N), we would be looping over the entire thing O(N * N) = O(N^2). But since we may have to loop over every element recursively, the time complexity should be around O(N^N)... Not sure if this is correct, but if it is, it is not good.
# > Another idea:
# >> Loop over the array and put each value into a HashMap.
# >> While looping, also check to see if current - 1 is already in  the HashMap. If it is, we've found the next element in that sequence. We then add an entry to the HashMap where the key is our current element and the value is the value from Map[current - 1] with current concatenated onto the end (note that the HashMap will contain arrays, so we aren't really concatenating anything). By the time we reach the end of the array in one pass, we will have built up the longest _consecutive_ sequence in the array. However, we will not have yet joined any values/sequences that might be able to be concatenated. So this isn't an entirely complete solution...