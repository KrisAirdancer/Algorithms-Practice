package problems_000_to_100;

public class RemoveDuplicatesFromSortedArray_26 {

	public static void main(String args[]) {
		
		int[] nums = {1, 2, 4, 4, 4, 5};
		
		System.out.println(removeDuplicates_3(nums));
		
	}
	
	/**
	 * Attempt 3
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the entire input array. When a new number is found, insert it at the beginning of the array
	 * in the next "open" space. The first element will be skipped (not checked) b/c it is guaranteed to
	 * be unique. Will need two indexes: searchIndex (for the element that is currently being evaluated) and
	 * insertionIndex (to specify the next "open" space at the beginning of the array). When the search is
	 * complete, return the LENGTH (NOT index) of the portion of the array that contains the unique values.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Initialize insertionIndex = 1;
	 * - Indexed for loop with searchIndex = 1 (start at index = 1)
	 * 		- if searchIndex != searchIndex - 1, insert searchIndex at insertionIndex and insertionIndex++
	 * 
	 */
	public static int removeDuplicates_3(int[] nums) {
		
		int insertionIndex = 1;
		
		for (int searchIndex = 1; searchIndex < nums.length; searchIndex++) {
			if (nums[searchIndex] != nums[searchIndex - 1]) {
				nums[insertionIndex] = nums[searchIndex];
				insertionIndex++;
			}
		}
		
		return insertionIndex; // Return the insertion index because it is also the length of the portion of the array that contains the unique values
	}
	
	/**
	 * Attempt two
	 * 
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates_2(int[] nums) {
        
        int insertionIndex = 1;
        
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] != nums[index - 1]){
                nums[insertionIndex] = nums[index];
                insertionIndex++;
            }
        }
        return insertionIndex;
    }
    
    /**
     * Attempt one
     * 
     * @param nums
     * @return
     */
    public static int removeDuplicates_1(int[] nums) {
        
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

    public static int removeDuplicates_ModelSolution(int[] nums) {
		// Small optimization for a length 0 array
    	if (nums.length == 0) {
    		return 0;
    	}
    	// Initializing the insertion index
		int insertionIndex = 1;
		// Search the entire array
		for (int searchIndex = 1; searchIndex < nums.length; searchIndex++) {
			// If a new number is found, insert it into the unique values list then increment insertionIndex
			if (nums[searchIndex] != nums[searchIndex - 1]) {
				nums[insertionIndex] = nums[searchIndex];
				insertionIndex++;
			}
		}
		
		return insertionIndex;
    }
}

/*
 * ********* ATTEMPT 2 **********
 * RESTATEMENT OF PROBLEM:
 * - Remove duplicates in place and return the length of the original array that contains
 * the set of unique values. That is, if input = [1, 1, 1, 2, 2, 5, 7, 7, 18], then the
 * correct output would be length = 5 and input should have been modified to be
 * input = [1, 2, 5, 7, 18, 5, 7, 7, 18]. The length value that is returned tells the
 * user which part of the array contains the list of unique values. 
 * NOTE: This is a really crappy design. Don't do this in the real world.
 * 
 * SOLUTION IDEA:
 * - Loop over the entire array once, keep two indexes running, 1) the insertion index and
 * 2) the search index. The search index should check each number and the one just before
 * it. When the current value doesn't equal the preceeding value, set the insertion index
 * (input[insertionIndex]) equal to the current value (input[searchIndex]). The first item
 * in the array is already in the correct location. The first item will be the unique value
 * for that value.
 * - Start the insertionIndex at 1 and the searchIndex at 1.
 *
 * 
 * FULL SOLUTION DESCRIPTION:
 * 
 * DEFINITIONS OF VARIABLES AND PARAMETERS:
 * 
 * PSEUDO-CODE SOLUTION:
 * - Declare and initialize insertionIndex = 1
 * - for loop to loop over entire array index = 1
 *      - if block to check if the current value != the previous value
 *          - If false, set searchIndex value = currentIndex value
 *           - Increment insertionIndex
 * - return searchIndex // This will be the length of the array that contains the 
 * list of unique values. NOTE: The searchIndex will be pointing to the first non-unique value, but
 * because we want the user to konw the LENGTH of the unique values array, we need to be last index + 1
 * Just like getting the length of any array is one larger than the value of the last index because
 * the index count starts at 0. So if we return a length of 3, this means that the indexes 0, 1, and 2
 * contain unique values. Three index places = length 3.
 * 
 */