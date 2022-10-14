public class Solution {
    
    /**
     * IDEA:
     * - Loop over the array. On each loop, keep track of the element at the start of the
     *   range and the current element. When the next element (the one after the current
     *   element) is larger than the current element by more than one (next > current + 1),
     *   add a properly formatted string with startElement and currentElement to the return
     *   list. Then, set startElement to nextElement and start the loop over.
     * 
     * EDGE CASES:
     * - List of length zero
     *     - Check for lists of length zero at top of SummaryRanges() and return an empty
     *       IList<string> if the input list is empty.
     * - List of length one
     *     - Should be handled by the algorithm just fine.
     * 
     * PERFORMANCE: 
     * - Time Complexity: O(N) - Only need to loop over the list once. N is the number of
     *                    elements in the input list.
     * - Memory Complexity: O(N) - Need to store the input list and potentially a copy of it
     *                      if each element in the input list is sepearated and thus requries
     *                      its own unique range. Thus, O(2N) worst case, but drop the constant
     *                      so O(N). Where N is the number of elements in the input list.
     * 
     * OUTLINE:
     * - Create new ArrayList<string> ranges
     * - If nums.Length == 0, return empty ArrayList (ranges)
     * - int startElement = nums[0]
     * - Loop while nextElement != null
     *     - int currentElement = nums[i]
     *     - int nextElement = nums[i + 1]
     * 
     */
    public IList<string> SummaryRanges(int[] nums) {
        
        IList<string> ranges = new List<string>();
        
        if (nums.Length == 0) { return ranges; }
        
        int current = 0;
        
        while (current < nums.Length) {
            
            int startElement = nums[current];
            
            while (current < nums.Length - 1 && nums[current + 1] == nums[current] + 1) {
                current++;
            }
            
            if (startElement == nums[current]) {
                ranges.Add($"{startElement}");
            } else {
                ranges.Add($"{startElement}->{nums[current]}");
            }
            
            current++;
        }
        
        return ranges;
    }
}

















