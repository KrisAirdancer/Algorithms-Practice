class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        distances = []
        for X, Y in points: # O(N) - Calculate the Euclidian Distance for each of the points in the input list.
            # There is no need to take the square root b/c a larger number will have a larger square root than a smaller number and vice-versa.
            distance = ((X ** 2) + (Y ** 2))
            distances.append([distance, [X, Y]])

        heapq.heapify(distances) # O(N) - Generate a Min Heap.

        kPoints = []
        while k > 0: # O(klogN) - Pop the first K points from the heap and add them to the return list.
            item = heapq.heappop(distances)[1] # Working
            kPoints.append(item)
            k -= 1

        return kPoints

# PERFORMANCE
# Time Complexity: O(klogN) - Since the slowest part is popping from the heap in the final step is O(logN) and we have to pop k times.
#   > If k == N, then performance is O(NlogN).
#   > The alternative sorting solution always runs in O(NlogN) time b/c sorting takes O(NlogN) time. So the Heap solution is slightly (very slightly) better.
# Memory Complexity: O(N) - We have to store a heap of N values and an output array of k values (k == N is possible). So worst case we have O(2N), which is just O(N).

# ***** IDEAS *****
# IDEA 1:
# > One method would be to calculate the Euclidian Distance for each point O(N) and place all of the Euclidian Distances in a Min Heap. From here, we simply return the first K elements on the heap.
# > The only issue with this approach is that we need to return the points and not their Euclidian Distances and putting tuples or other objects into a heap will result in unexpected behaivor (the X and Y values will be used to break ties, which will be unpredicatable and not provide the ordering we want) in the event that two points have the same Euclidian Distance.
#   > Note: If Euclidian Distance takes direction into account (it is a vector), then so long as we are guaranteed not to get duplicate points (we aren't explicitly given this guarantee), then we could put tuples of (Euclidian Distance, Coordinates) into the heap.
#   > Another solution to this issue would be to put the Euclidian Distances into the heap, then reverse the equation to get the (x, y) coordinates back out when popping off of the heap. However, I don't think this is possible (at least not without some advanced mathematics), so this option is out.
# Note: "Guaranteed to be unique" means that there will not be any points that are the same distance away from the origin.
# Optimization: Instead of adding the top K points to a return list from the Min Heap, we can sort the elements in a Max Heap and pop the top heap.size - K elemenets from the heap and then just return the heap.
#   > This only works because we are allowed to return the answer in any order. Otherwise, we would have to sort this list b/c this solution will be returning the list of elements in "heap order" - the elements are not stored in the backing array for the heap in ascending or descending order.
# NeetCode:
# > This solution does exactly what I proposed. In fact, it even ignores the issue with adding to a heap that I was worried about. Specifically, it adds each point to the heap as a group of [Euclidian Distance, X, Y]. This way it sorts using the first field, as I proposed. What I was missing is that we won't ever need to break any ties. This is why the problem is set up the way it is. If we had to break ties, the heap alg would use the second, then third, and so on values in the objects we are heapifying to break those ties. But because we are guaranteed that there will be no points with the same Euclidian Distance, we don't have to worry about tie breaking and can just heapify normally.