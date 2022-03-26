public class Solution {
    
    
    /// <summary>
    /// 
    /// IDEA:
    /// Make two pointers, one at either end of the input array. Swap the letters at the pointers then move the
    /// pointers towards the middle of the array. When the pointers cross over, the reversal is complete.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(1)
    ///
    /// OUTLINE: 
    /// Initialize pointers: left = 0, right = s.Length - 1
    /// Loop while left < right (no need to swap when they are equivalent)
    ///     Swap elements at the two pointers
    ///     Increment/Decrement pointers
    /// 
    /// </summary>
    public void ReverseString(char[] s) {
        
        int left = 0;
        int right = s.Length - 1;
        
        while (left < right) {
            
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
}