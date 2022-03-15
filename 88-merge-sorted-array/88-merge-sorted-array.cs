public class Solution {
    
    /// <summary>
    /// General Idea: Step over the arrays backwards.
    /// As we go, move items from each of the arrays to the
    /// rightmost space in nums1 (either move the element
    /// in nums1 back or transfer the element from nums2).
    /// When we reach the left of nums2, return.
    /// </summary>
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        
        int index_1 = m - 1;
        int index_2 = n - 1;
        int insertion = m + n - 1;
        
        while (index_2 >= 0) {
            
            if (index_1 >= 0 && nums1[index_1] > nums2[index_2]) {
                
                nums1[insertion--] = nums1[index_1--];
                
            } else {
                
                nums1[insertion--] = nums2[index_2--];
            }
        }
    }
}