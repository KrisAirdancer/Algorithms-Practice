public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Loop over the entire input array nums. For each element in nums, if that element has
    /// already been seen, check to see if abs(currentElementIndex minus it's duplicate) is 
    /// less than or equal to k. If it is, return true. If the end of the list is reached
    /// and no elements matching the critiera have been found, return false.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(N) 
    /// 
    /// OUTLINE: 
    /// Create a Dictionary<int, int> to store the closest element to the currentElement pointer along with it's index
    /// Loop over nums using an indexed for loop
    ///     If an element is already in the Dictionary and currentIndex - duplicateValIndex <= k, return true
    /// return false
    /// 
    /// </summary>
    public bool ContainsNearbyDuplicate(int[] nums, int k) {
        
        Dictionary<int, int> elements = new Dictionary<int, int>();
        
        for (int i = 0; i < nums.Length; i++) {
            
            if (elements.ContainsKey(nums[i]) && Math.Abs(i - elements[nums[i]]) <= k) {
                return true;
            }
            if (elements.ContainsKey(nums[i])) {
                elements[nums[i]] = i;
            } else {            
                elements.Add(nums[i], i);
            }
        }
        return false;
    }
}
