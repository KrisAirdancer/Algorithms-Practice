package remove_duplicates_from_sorted_array_26;

public class Attempt1 {

    public int removeDuplicates(int[] nums) {
        
        // Loop over entire array
            // Keep track of insertion position for next unique value AND current value being evalutated
        // When a unique value is found, insert it at insertionIndex
        
        // Two nested for loops
            // Outer - tracks the general index (index)
            // Inner - tracks the insertionIndex
        // On exiting the loops, return the size of the array
        
        int insertionIndex = 0;
        
        for (int index = 0; index < nums.length; index++) {
            if (nums[insertionIndex] != nums[index]) {
                insertionIndex++;
                nums[insertionIndex] = nums[index];
            }
            
        }
        
        return insertionIndex + 1;
    }

}
