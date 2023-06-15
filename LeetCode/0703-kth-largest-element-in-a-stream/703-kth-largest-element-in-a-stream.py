# Your KthLargest object will be instantiated and called as such:
# obj = KthLargest(k, nums)
# param_1 = obj.add(val)

class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.k = k
        self.values = nums
        heapq.heapify(self.values) # Generate a min heap (heaps are represented as arrays in Python, so this just rearranges the elements in the array so that the array represents a heap structure).
        while len(self.values) > self.k: # Reduce the size of the heap to k.
            heapq.heappop(self.values)

    def add(self, val: int) -> int:
        heapq.heappush(self.values, val) # Add the new value to the heap.
        while len(self.values) > self.k: # Reduce the size of the heap to k.
            heapq.heappop(self.values)
        return self.values[0] # The root value of the heap is stored in the 0th index, return the root value, which is the kth largest.
        
# ***** IDEAS *****
# PERFORMANCE (NeetCode solution):
# > Time Complexity:
#   > __init__() - O(NlogN) b/c we need to add all N elements to the heap and each addition takes O(logN) time. Plus we need to remove N - k elements which is O((N - k)logN). This reduces to O(NlogN).
#   > add() - O(logN) b/c we need to add the new element and then reduce to size k. Since the heap is already size k before the addition of the single element, we only need to perform one heap.push() and one heap.pop(). Both operations are O(logN), so we get O(2logN), which reduces to O(logN).
# NEETCODE:
# > Use a Min-Heap to keep track of the elements that are added to the data structure.
#   > This will allow us to keep track of the kth largest element easily.
# > What we do is this,
#   > On initialization, we add all of the elements to a min-heap. Then, we remove elements from the heap until there are only k elements left in the heap. The heap's root now contains the kth largest element.
#   > On each add() call, we add the element to the heap, then reduce the heap to size k. From here, we just return the root, which is, again, the kth largest element.
# > Note: We use a Min Heap and not a Max Heap b/c it allows us to get the kth largest element in the root position. If we used a max heap, we'd have to traverse to the bottom of the heap to get the kth largest element. This would take O(N) time instead of O(logN) time b/c we don't know where in the graph the last node in the tree is, which would be the kth largest, so we'd have to traverse it with DFS or BFS to find the last node. This would also be difficult to implement.
# IDEA 1:
# > We don't want to iterate through to reach the kth element every single time add() is called. Thus, we will need to come up with a way to keep track of the kth element as it changes.
#   > If we store the list of values in an array, we can just index to the [-3] position for O(1) access. But we might not use an array b/c updating the list would take O(N) time, and I think we can do better than O(N).
# ***** BCR *****
# > O(1) - It might not be possible to reach constant time, but since we don't need to keep a formal list of all of the values - we only need to keep track of the kth largest - we might be able to do something that simply updates the kth largest and doesn't update a list.
#   > If we aren't able to do this, then the BCR will be either O(N) - iterating through the list to insert the new element in the correct location or O(NlogN) - for sorting the list after adding the new element to it.
#   > It will still only take O(1) time to access the kth largest in the list due to array indexing.
# BFSol:
# > Keep an array of the given values (nums). Then, each time add() is called, iterate through the list and insert the new element into the list - O(N) time. Once the new element is inserted in the correct sorted order, return the kth to last (kth largest) element in the array.
#   > This solution isn't bad, but it will run in O(N) time and it seems like there should be a way to do this in O(1) time.
#   > Since we only need to keep track of the kth largest element, we don't really need to keep track of the whole list.
#   > Alright, here's the catch. We can't, from what I can tell, do it in O(1) time b/c when we add an element to the left of the kth largest element, the kth largest doesn't change, so we don't need the left half of the list (also note that the kth largest will only ever shift right during element addtion). However, if a value to the right of kth largest (a larger value) is added, we will need to know what the value to the right of kth largest is inorder to return the correct value. Thus, we will need to keep track of at least the right half of the list. This means that we will have to do it in at least O(N) time.
# > Wait, what if we keep a dictionary of updates - {value:count}.
#   > If add() is called with a value larger than kth largest, we can add it to the dictionary, then loop starting at kth largest and check if each value k, k+1, etc. are in the dictionary. When we find a value in the dictionary, ... this is still O(N) time.
# > We could also do an optimization on the BFSol to use Binary Search to find the insertion location of the new element passed to add(). This would reduce the runtime to O(logN).
#   > Except that if we have to copy the original list in the constructor. In which case, the constructor would have a runtime of O(N) and add() would have a runtime of O(logN).
# But, the initial list - nums - is not guaranteed to be sorted. So we would have to sort it first. This would take O(NlogN) time.
