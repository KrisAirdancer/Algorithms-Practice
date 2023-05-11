class Solution:
    def findMin(self, nums: List[int]) -> int:
        left = 0
        right = len(nums) - 1

        smallestSoFar = nums[0]

        while left <= right:
            mid = left + ((right - left) // 2)

            # If our current subarray is fully sorted, its leftmost value (left) will be less than its rightmost value (right).
                # When this happens, is is our last iteration. We will only need to check if the leftmost value in this subarray is smaller than the current smallestSoFar value.
            if nums[left] <= nums[right]:
                # In this case, we check to see if the smallest value in this subarray (left) is smaller than smallestSoFar and update accordingly.
                if nums[left] < smallestSoFar:
                    smallestSoFar = nums[left]
                    print(smallestSoFar)
                    break

            # Here, we check to see if smallestSoFar needs to be updated on this iteration. We do this here and in the above if block because the one above only runs on the final iteration, which means we might miss some smaller values.
            if nums[mid] < smallestSoFar:
                smallestSoFar = nums[mid]

            if nums[mid] >= nums[left]: # mid is in the left sorted portion
                left = mid + 1 # Search the right sorted portion. Cut off the left half of the current subarray.
            else: # nums[mid] < nums[left] - mid is in the right sorted portion
                right = mid - 1 # Search the left half of the right sorted portion. Cut off the right half of the current subarray.
        
        return smallestSoFar

# ***** IDEAS *****
# We are going to have to use Binary Search to accomplish this task in O(logN) time.
# > We will need to modify the Binary Search to know where to find elements that are higher or lower than the current midpoint.
# >> It should be noted that the rotate operation wraps elements around. This means, that there could be elements that are larger than the current midpoint to the left of it (in addition to smaller values) OR (not and) there could be smaller values to the right of the midpoint in addition to larger values.
# >> Ex. [1, 2, 3, 4] -> [4, 1, 2, 3] after rotation has a 4 to the left of 2. If mid is 2, there are both larger and smaller values to the left of mid.
# >> Ex. [1, 2, 3, 4] -> [2, 3, 4, 1] after rotation has a 1 to the right of 3. If mid is 3, there are both smaller and larger values to the right of mid.
# We cannot do any stepping through the array to determine the offset b/c this will take O(N) time and will push our time complexity above the acceptable level.
# Idea: Can we just set the left and right pointers to the extremes in the list (the max and min values) and then treat it like normal Binary Search?
# > Ex. For [4, 5, 6, 7, 1, 2, 3], if left = 4 and right = 3 (indexes 4 and 3) and target = 6.
# >> mid = left + ((right - left) // 2) = 4 - ((3 - 4) // 2) = 4 - (-1 // 2) = 4 - (0) = 4
# >> Nope: This won't work.
# Idea: If we could determine the rotation amount, we would be able to simply offset our Binary Search indexes by that amount.
# > Ex. If the array was rotated by 2, then we could set left = 0 + 2 and right = len(nums) - 1 + 2.
# > However, I think this will get us right back to where I was before. The only difference is that we won't have to perform an O(N) search operation to find the rotation amount. But it will still result in the wrong index being calculated for the midpoint.
# Wait, I've gotten distracted. We don't need to search for some given target. We are being asked to find the smallest value in the array.
# > This means that if we can find the rotation point split (Ex. [..., 5, 1, ...]) we will have found the smallest element.
# NeetCode
# > NeetCode's recommended solution is to notice that during rotation, each item that is moved from the right end of the array to the left end is the largest in the right half of the array. This means two things: 1) The value in the leftmost position of the rotated array will be the smallest value in the left sorted portion of the rotated array and 2) the value in the rightmost position of the rotated array will be the largest value in the right sorted portion of the rotated array.
# > This observation means that we can determine which half we are in when we choose any given value in the rotated array - such as when we select a midpoint during Binary Search.
# > To summarize:
# >> If mid >= leftmostElement, we are in the leftmost sorted portion.
# >>> B/c all elements in the rightmost portion will be larger than those in the leftmost portion.
# >> If mid < leftmostElement, we are in the rightmost sorted portion.
# >>> B/c all elements in the leftmost portion will be smaller than those in the rightmost portion.
# > For example, if we have [4 5 6 7 1 2 3], our midpoint is 7. If we choose to compare to the leftmost element, we will find that 7 is larger. This means that we are in the left sorted portion - 7 is larger than all values in the right sorted portion. Thus, we set leftPtr = mid + 1. On the next iteration, we get mid = 2. Here, we compare to the leftmost element in the partition: 1. 2 is larger than the leftmost element, so we know that we are in the right sorted portion and need to search the left to find a smaller value. So we set right = mid - 1. On the next iteration we have left = 1 and right = 1 and mid = 1. On comparison, we find that 1 is greater than OR EQUAL TO 1, so we know that we are in the right sorted portion. However, at this point, the search loop will break and we will exit with 1 as our minimum value in the array.
# > A second example: [4 5 6 7 8 1 2 3]
# >> On the first iteration, left = 4, right = 3, and mid = 7.
# >> Since 7 >= 4, we know that we are in the left sorted portion.
# >> Thus, we know that we need to search the right portion to find our minimum.
# >> We set left = mid + 1.
# >> On iteration two we have, left = 8, right = 3, and mid = 1.
# >> Since mid < the leftmost element, we know that we are in the right sorted portion and should continue to search there.
# >> We set right = mid - 1 and smallestSoFar = 1
# >> On iteration three we have, left = 8, right = 8, and mid = 8.
# >> This iteration runs with 8 >= 8, which tells us that we are in the left sorted portion.
# >> It then sets left = mid + 1.
# >> Then breaks from the loop b/c left is now greater than right.
# >> We now return smallestSoFar = 1
# ***** OUTLINE *****
# Instantiate left = 0 and right = len(nums) - 1
# Instantiate smallestSoFar = nums[0] # If array was rotated n times, this will be our correct minimum.
# Loop: While left <= right,
#     mid = left + ((right - left) // 2)
#     If mid >= nums[left],
#         Set left = mid + 1
#     If mid < nums[left],
#         Set right = mid - 1
#         Set smallestSoFar = nums[mid]
# Return smallestSoFar
















