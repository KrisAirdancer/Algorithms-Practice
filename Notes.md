class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        target = len(nums) - k

        def quickSelect(left: int, right: int): # When not using nested functions, we would need to pass in the list (nums) and the target (k or target).
            pivot = right
            current = left
            firstLarger = left

            # Partition elements.
            while current < right:
                if nums[current] <= nums[pivot]:
                    # Swap smaller element at current with larger element at firstLarger.
                    temp = nums[firstLarger]
                    nums[firstLarger] = nums[current]
                    nums[current] = temp

                    firstLarger += 1
                
                current += 1

            # Swap pivot with firstLarger
            temp = nums[firstLarger]
            nums[firstLarger] = nums[pivot]
            nums[pivot] = temp

            # Check pivot against target

            
            # Make next recursive call


            # TODO: Don't we need some kind of base case?



        quickSelect(0, len(nums) - 1)

# PERFORMANCE
# Time Complexity: O(NlogN) - Since we have to iterate over every item in the input array, the minimum complexity is O(N). Then, since we will be pushing each item to a heap, an O(logN) operation, we get O(NlogN) for the overall complexity. It will be slightly higher than this since we will be performing a heappop() opearation (O(logN) operation) for N - K elements in the heap to maintain the size of the heap at size = K.
# Memory Complexity: O(N) - Since we only have to store the heap, we only need O(N) space.

# ***** IDEAS *****
# IDEA 1:
# > Note: We are required to solve this in O(N) time. Since O(logN) is faster than O(N), we are able to use O(logN) operations to accomplish the task.
#   > This means that we can't sort, but it does mean that we can use a Heap to keep track of elements.
# > One idea is to iterate over the list of elements and add each element to a Min Heap and keep the heap at size K (add an item, then remove the root item to reduce to size K). This will result in the Kth largest element occupying the root position in the heap. We can then just return the heap.
#   > One major issue with this, however, is that the input lists contain duplicate values.
#   > This problem could be solved by creating an O(2N) solution, where we add all of the elements to a Set() so as to get rid of the duplicates, then iterate over the set and add each element to the heap.
# > WAIT! I messed up, the question is asking us to return the Kth largest in sorted order so as to account for duplicates. Example 2 clearly shows this.
# > In this case, the naive solution should work. Just add everything to a Min Heap and then reduce the size of the heap down to size K.
#   > This is probably wrong since this solution is identical to another problem I've solved.
#   > Nope. It worked.