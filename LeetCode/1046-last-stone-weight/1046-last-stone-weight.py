class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        maxHeap = [-stone for stone in stones] # Use list comprehension o generate a list of stones with negative masses to allow for the use of a Max Heap (Python doesn't have a Max Heap natively, so we have to use a Min Heap with negative values to get a Max Heap).
        heapq.heapify(maxHeap)

        while len(maxHeap) > 1: # Loop until the heap is of size 1 or less.
            difference = heapq.heappop(maxHeap) - heapq.heappop(maxHeap)
            if difference != 0: # If the two stones aren't destroyed (mass == 0), push the remaining stone (mass >= 1) to the heap.
                heapq.heappush(maxHeap, difference)
        
        if maxHeap: # If there is a stone remaining on the heap, return its mass.
            return heapq.heappop(maxHeap) * -1 # Times negative one b/c the heap is storing values as negatives.
        return 0 # If there are no stones in the heap, return 0.

# ***** IDEAS *****
# IDEA 1:
# > Use a Max Heap to keep track of the stones. This will allow us to get the largest item in O(logN) time (have to percolate after removal).
# > Loop until the Max Heap is either empty or contains only a single element. After the loop, if only one item remains, return it; if no items remain, return 0.
#   > In the loop, pop the two largest elements from the heap, subtract them from each other (make sure to subtract the smaller from the larger), then push the result back onto the heap.
#   > If the result is 0, don't push to the heap.
#   > Note, because of the ordering imposed by the Max Heap, it is impossible to get a negative value during subtraction.
# ***** PERFORMANCE *****
# > Time Complexity: O(NlogN) - Adding all of the items to the heap is O(NlogN). Each iteration of the reduction loop removes one item from the heap, so this will take O(N) time. Thus, our overall complexity is O(N).
# > Memory Complexity: O(N) - We have to store a heap of size N, so the memory complexity is O(N).