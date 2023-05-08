public class Solution {
    
    /// <summary>
    /// Loop over one of the arrays and use binary search to find the current element in the other
    ///
    /// Pseudo-Code:
    /// 
    /// Sort nums2 (binary search requires a sorted list)
    /// 
    /// Create a new HashSet to be returned (will need to convert it to a vanilla array)
    /// 
    /// For each element in nums1 (for loop)
    ///     If first != last,
    ///         Binary search nums2 for the element in nums1
    ///         If element is in both, add element to ArrayList
    /// Convert HashSet to an array and return it
    /// 
    /// </summary>
    public int[] Intersection(int[] nums1, int[] nums2) {
        
        Array.Sort(nums2);
        
        HashSet<int> intersection = new HashSet<int>();
        
        for (int i = 0; i < nums1.Length; i++) {

            if (BinarySearch(nums2, nums1[i])) {
                intersection.Add(nums1[i]);
            }
        }
        
        // Convert HashSet to int[]
        int[] intersectionArray = new int[intersection.Count];
        int index = 0;
        foreach (int element in intersection) {
            intersectionArray[index++] = element;
        }
        
        return intersectionArray;
    }
    
    public bool BinarySearch(int[] list, int target) {
        return BinarySearch(list, target, 0, list.Length - 1);
    }
    
    private bool BinarySearch(int[] list, int target, int left, int right) {
        
        while (left <= right) {
            
            int mid = left + ((right - left) / 2);

            if (list[mid] == target) {
                return true;
            } else if (list[mid] > target) {
                right = mid - 1;
            } else if (list[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }
}