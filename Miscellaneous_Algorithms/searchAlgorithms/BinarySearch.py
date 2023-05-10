from typing import List

class BinarySearch:
   
    def binarySearchIterative(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = left + ((right - left) // 2)

            if target < nums[mid]:
                right = mid - 1
            elif target > nums[mid]:
                left = mid + 1
            else: # Target found
                return mid
            
        return -1
    
    def binarySearchRecursive(self, nums: List[int], target: int) -> int:

        return self.binarySearchHelper(nums, target, 0, len(nums) - 1)

    def binarySearchHelper(self, nums: List[int], target: int, left: int, right: int):
        mid = left + ((right - left) // 2)
        print("left: ", left, ", right: ", right, ", mid: ", mid, ", nums[mid]: ", nums[mid])

        if left > right: # Target not present in list
            return -1

        if target < nums[mid]:
            return self.binarySearchHelper(nums, target, left, mid - 1)
        elif target > nums[mid]:
            return self.binarySearchHelper(nums, target, mid + 1, right)
        else: # Target found
            return mid

#        0 1 2 3 4  5
nums = [-1,0,3,5,9,12]
target = 9
bs = BinarySearch()
# Test with extant target
print(bs.binarySearchIterative(nums, target))
print(bs.binarySearchRecursive(nums, target))
# Test with non-extant target
target = 14
print(bs.binarySearchIterative(nums, target))
print(bs.binarySearchRecursive(nums, target))