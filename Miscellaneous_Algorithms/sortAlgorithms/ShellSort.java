package sortAlgorithms;

import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		
		int[] test = {7, 6, 8, 9, 3, 2, 10, 5, 1};
		
		shellSort_Model_Solution(test);
		System.out.println(Arrays.toString(test));

	}
	
	public static void shellSort_Model_Solution(int[] input) {
		/* Setting out gap value. This can be done outside of a loop, but 
		 * doing it in a for loop keeps it organized.
		 * 1) We are setting the 
		 * gap value to be half of the input array's length.
		 * 2) We loop (sort the array) until the gap value reaches zero.
		 * 3) Each loop, we shrink the gap value by dividing the current
		 * gap value by 2. */
		for(int gap = input.length / 2; gap > 0; gap = gap / 2) {
			System.out.println("gap: " + gap);
			/* Here, we create a new index with a starting value equal to our
			 * gap value. We then loop over the array until our gap value
			 * has been incremented to be equal to the length of our
			 * input array. */
			for (int gapIndex = gap; gapIndex < input.length; gapIndex++) {
				System.out.println("gapIndex: " + gapIndex);
				// Create a temporary variable to hold the element currently being evaluated
				int currentElement = input[gapIndex];
				System.out.println("currentElement: " + currentElement);
				// Create a temporary copy of our gap value
				int tempGap = gapIndex;
				System.out.println("tempGap (upper): " + tempGap);
				// Swap elements
				while (tempGap >= gap && input[tempGap - gap] > currentElement) {
					System.out.println("tempGap (lower):" + tempGap);
					input[tempGap] = input[tempGap - gap];

					tempGap = tempGap - gap;
				}
				
				input[tempGap] = currentElement;
				System.out.println(Arrays.toString(input));
			}
		}
	}

}
