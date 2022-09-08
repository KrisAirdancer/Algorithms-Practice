class Solution {
    
    /**
     * IDEA:
     * - Since we are guaranteed that there will be a majority element and the majority element is
     * defined as an element whose frequency is greater than half the length of the array,
     * we are guaranteed that if the array is sorted, one of the copies of the majority element
     * will be present at the middle index of the array - nums.length / 2. Thus, we sort the array,
     * then we return the middle element.
     * 
     * OUTLINE:
     * - Sort the arrary
     * - Return the middle element
     * 
     * PERFORMANCE:
     * - O(NlogN) time complexity - because Java's built in Arrays.sort() method uses a variant of
     *   quicksort, the input array can be sorted in linearithmic time. Returning the middle element
     *   can be done in constant time with array indexing.
     *     - Note: If we wanted to ensure that this algorithm does NOT manipulate the original
     *       input array, we would need to duplicate the input array. This would take O(N) time,
     *       but even then, the overall performance would be O(NlogN) as linearithmic is slower
     *       than linear time.
     * - O(N) memory complexity - we only need to store the original input array.
     *     - Note: If duplicating the array to prevent modification of the original, the memory
     *       complexity would go from O(N) to O(2N), still linear.
     */
    public int majorityElement(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        return numsCopy[numsCopy.length / 2];
    }
}