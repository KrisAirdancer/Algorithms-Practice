class Solution {
    
    /**
     * IDEA:
     * - Loop over the input array. Add each element to a HashSet. If the element
     *   is already in the HashSet, return true. If the loop completes without
     *   returning early, there are no duplicates.
     * 
     * PERFORMANCE:
     * - Time Complexity: O(N) - Only need to loop over the input array onece.
     *   Therefore, O(N).
     * - Memory Complexity: O(N) - Need to store the input array itself as well as,
     *   potentially, a copy of it if all elements are added to the HashSet. Therefore,
     *   O(2N), which is just O(N).
     * 
     */
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> values = new HashSet<Integer>();
        for (Integer element : nums) {
            if (values.contains(element)) {
                return true;
            } else {
                values.add(element);
            }
        }
        
        return false;
    }
}