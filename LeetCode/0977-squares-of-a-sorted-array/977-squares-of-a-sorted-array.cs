public class Solution {
    
    /// <summary>
    /// 
    /// Idea: Use two pointers to loop over the input array. One pointer starts
    /// at length - 1 and the other starts at the smallest (leftmost) negative
    /// value. The right pionter traverses to the left and the left pointer 
    /// traverses to the right. The absoulte value of each of the values
    /// at each of the pointers are compared and the highest one is squared and
    /// added to the end of a new array. Then the pointer that was squared is
    /// decremented or incremented by one. Continue until all values have been
    /// processed.
    /// 
    /// Outline:
    /// 
    /// Initialize a new int[] of the same size as input array
    /// Initialize two pionters (one to start at leftmost value and one at the rightmost value)
    /// while (left <= right)
    ///     If abs(left) > abs(right),
    ///         Add left * left to new array
    ///     else, // rigth is greater than left
    ///         Add right * right to new array
    /// return new array
    /// 
    /// </summary>
    public int[] SortedSquares(int[] nums) {
        
        int[] squares = new int[nums.Length];
        
        int i = nums.Length - 1;
        int right = nums.Length - 1;
        int left = 0;
        
        while (left <= right) {
            
            if (Math.Abs(nums[left]) > Math.Abs(nums[right])) {
                squares[i] = nums[left] * nums[left];
                left++;
                i--;
            } else {
                squares[i] = nums[right] * nums[right];
                right--;
                i--;
            }
        }
        return squares;
    }
}