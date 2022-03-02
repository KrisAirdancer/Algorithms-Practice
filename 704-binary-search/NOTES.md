// Base case: low > high
// Calculate midpoint
// If target == nums[mid], return mid (mid is the element's index)
// If target < nums[mid], search left partition
// If target > nums[mid], search right partition
// Else, return -1