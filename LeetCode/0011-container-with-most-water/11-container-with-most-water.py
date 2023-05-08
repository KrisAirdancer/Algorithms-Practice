class Solution:
    def maxArea(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1

        maxSoFar = min(height[left], height[right]) * (right - left)

        while left < right:
            area = min(height[left], height[right]) * (right - left)

            if area > maxSoFar:
                maxSoFar = area
            
            if height[left] < height[right]:
                left += 1
            elif height[right] < height[left]:
                right -= 1
            else: # Heights are equal
                right -= 1
        
        return maxSoFar

# IDEAS
# > As far as I can tell, this problem is asking us to find the maximum area between the two selected columns.
# >> Differential filling is not allowed. That is, the water level accross the whole array maxes out at the height of the shortest **selected** column.
# Option 1 - BFSol
# > The first approach that comes to mind is to use two pointers (left and right) to loop over the array to find the two columns that maximize the area of a rectangle: Area = Height x Width.
# > Broken down into code, that equaation is: Area = Height x Width = (max(height[left], height[right])) x (right - left)
# > The idea is this: loop over the array with the two pointers (left and right). Continue until left == right. For each column at left, loop over all other columns. For each pair of columns, calculate the maximum area and keep a maxSoFar variable. If the current area is greater than maxSoFar, update maxSoFar. After checking all possible combinations, return maxSoFar.
# > This solution will have a Time Complexity of O(N^2) and a Memory Complexity of O(N).
# Thinking
# > We can't sort it because that would destroy the ordering of the columns. This would allow us to find the two tallest columns quickly, but would prevent us from calculating the final area because we wouldn't know the proper width anymore.
# NeetCode Solution
# > Since the volume of the final container is the product of the width (the distance between the chosen columns) and height (the height of the shortest column), as we select columns that are closer together, the heights of those columns must be larger in order to support a greater area (volume). Thus, we can start at the outside edges of the array (leftmost and rightmost positions) and move inward. As we do so, we move the pointer of the smallest column inward. We continute this process until left = right. On each iteration, we check to see if the new area is greater than the current maxSoFar.
# > This works because we are essentially just searching for the tallest column in each half of the array.
# >> We are technically searching for the tallest columns farthest from the center (closest to the ends of the array). Since each half will only have one maximum value (there can be multiple columns of the same max height) and the array as a whole will only have one maximum value, we can be assured that we will never move the pointer that finds the global maximum once it is found and that we will always get a pointer "stuck" on the largest value of each half until a larger alternative in the other half has been found. Thus guaranteeing that we will find the pair of columns that genrates the maximum area.
# OUTLINE
# Instantiate a maxSoFar variable (int)
# Instantiate pointers: left and right
# Loop: While left != right
#     Calculate current area as area = min(height[left], height[right]) x (right - left)
#     If current area > maxSoFar, update maxSoFar
#     If height[left] < height[right], left++
#     Else, right-- # Right is smaller than left
# Return maxSoFar